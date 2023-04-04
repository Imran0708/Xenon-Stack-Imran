package com.controller;
import com.dto.UserDto;
import com.entity.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.FoodMenu;
import com.entity.GlobalData;
import com.repository.RestaurantRepository;
import com.service.BillDetailsService;
import com.service.EmailService;
import com.service.MenuService;
import com.service.RestaurantService;


@Controller
public class CartController 
{
	@Autowired
	private BillDetailsService bigbill;

	@Autowired
	private RestaurantService resService;

	@Autowired
	private RestaurantRepository repository;
	
	@Autowired
	private MenuService menucart;
	
	@Autowired
	EmailService emailService;
	
	
	/*
	 * @Autowired private IEmailSenderService emailSenderService;
	 */
	
	// add to cart 
	
			@GetMapping("/addToCart/{id}")
			public String addToCart(@PathVariable int id, Model model) {
				GlobalData.cart.add(menucart.getCartMenuById(id));
				
				return "redirect:/cart";
			}
			
			
			
			// cart count ,total, & data
			@GetMapping("/cart")
			public String cartGet(Model model) {
				model.addAttribute("cartCount",GlobalData.cart.size());
				model.addAttribute("total", GlobalData.cart.stream().mapToDouble(FoodMenu::getPrice).sum());
				model.addAttribute("cart", GlobalData.cart);
				return "cart";
			}
			
			
	//		 remove from cart
			@GetMapping("/cart/removeItem/{index}")
			public String cartItemRemove(@PathVariable int index) {
				GlobalData.cart.remove(index);
				return "redirect:/cart";
			}
			// checkouut details
			@GetMapping("/checkout")
			public String checkout(Model model) {
				model.addAttribute("total", GlobalData.cart.stream().mapToDouble(FoodMenu::getPrice).sum());
				BillingDetails bd=new BillingDetails();
				model.addAttribute("billDetails",bd);
				return "checkout";
			}
				

			@PostMapping("/savebillingdetails")
			public String billdetails(@ModelAttribute BillingDetails bdt,@RequestParam("total") String total, @RequestParam("ftotal") String ftotal, HttpSession session) {
				double totalT = Double.parseDouble(total);                       // Long.parseLong(total);
				bdt.settAmount(totalT);
				double totalF = Double.parseDouble(ftotal);
				bdt.setpAmount(totalF);
				bigbill.addBillDetails(bdt);	
         		String email=bdt.getEmail();
				String fname=bdt.getFirstName();
				String lname=bdt.getLastName();
				String addp=bdt.getAdrressp1();
				String addpt=bdt.getAdrressp2();
				String city=bdt.getCity();
				double tAmount=bdt.gettAmount();
				
				String subject="Food-Nerd";
				String message=""
						+ "<div style='border:1px solid #e2e2e2; padding:20px'>"
						+ "<h1>"
						+ "Order Booked Successfully"
						+ "<b>"+ " Visit Again" +"<br>"+"FirstName : "+ fname +"<br>"+"LastName : "+ lname+"<br>"
						+ "Address : "+addp+","+addpt+"<br>"+"City :"+city+"<br>"+"Amount :"+tAmount
						+ "</h1> "
						+ "</div>";
				String to=email;
				boolean flag = this.emailService.sendEmail(subject, message, to);
				
				if(flag)
				{
					System.out.println("Mail Sent");
				}else
				{	
					
					System.out.println("Mail Not Sent");
				}
				
			
				return "index";
				
			}

			
			/*
			 * // mail sender
			 * 
			 * @PostMapping("/register") public String insert(@ModelAttribute UserDto
			 * user,Model model) throws MailException, InterruptedException {
			 * service.saveuser(user);
			 * 
			 * emailSenderService.sendSimpleEmail(user.getEmail(), "Dear " +
			 * user.getFirstName() + " " + user.getLastName() + ",\n\n" +
			 * "  is successfully Registered.\n\n " //+ "paybel amount : "+gstamt //+
			 * "\n\n"+"order id : "+user.getUserId() + "\n" +"\n" + "\n"+"THANK YOU !!"
			 * +"\n"+ "Warm Regards,\n" + ",\n" + "CDAC Patna Services", "Enjoy Your Food!"
			 * );
			 * 
			 * return "login"; }
			 */
			
			
			
		}
			
		
			
			
	
