package com.controller;

//import java.net.http.HttpRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.UserDto;
import com.entity.User;

import com.service.EmailService;
import com.service.RestaurantService;
import com.service.UserService;

@Controller

@RequestMapping
public class HomeController {

	@Autowired
	UserService service;

	@Autowired
	RestaurantService RestService;
	
	@Autowired
	EmailService emailService;

	
	
	


//	controller for home page

	@GetMapping(value = { "/", " ", "/welcome", "/index"})
	public String Home(Model model) {
		model.addAttribute("showcards", RestService.getallRestaurants());

		return "index";
	}
	
	
	
//	for customer home
	

	// Controller to redirect About Us page
	@RequestMapping("/about_us")
	public String Aboutus() {

		return "about_us";

	}

	// Controller to redirect About Us page
	@RequestMapping("/Contact")
	public String ContactUs() {

		return "Contact";

	}

	@RequestMapping("/navbar")
	public String Navbar() {

		return "navbar";

	}

	// Controller to redirect login page
	@RequestMapping("/login")
	public String Login() {

		return "login";

	}
	
//	contoller to logout
	
	
//	  public String Logout(HttpSession session) { session.invalidate(); return
//	  "login";
//	  
//	  }
	 
	
	
//	  @RequestMapping("/logout") public ModelAndView logout(HttpSession Session){
	  
	  
//	  return new ModelAndView("redirect:/login"); }
	 

	
	
	
//	  @RequestMapping("/logout") public String logout(HttpSession session ) {
//	  session.invalidate(); return "redirect:/login.html"; }
	 

	
	
	@GetMapping("/logout")
	public String logout(HttpSession session,HttpServletRequest request) {
		session = request.getSession(false);
		
		  session.removeAttribute("User"); session.removeAttribute("Restaurant");
		  session.removeAttribute("DeliveryBoy"); session.removeAttribute("Ngo");
		 
		session.invalidate();
		Cookie[] cookie = request.getCookies();
		for(Cookie c:cookie)
		{
			c.setMaxAge(0);
		}
		
		return "redirect:/login";
	}

	


	// //Controller to redirect registration page
	@RequestMapping("/reg")
	public String reg(Model model) {
		model.addAttribute("user", new User());
		return "Registration";

	}
	
	/// controller to redirect when user not registered
	@RequestMapping("/invalid_User")
	public String signup(Model model) {
		model.addAttribute("user", new User());
		return "Invalid_login";

	}
	
	//to insert into db
	@RequestMapping("/register")
	public String insert(@ModelAttribute UserDto user,Model model,RedirectAttributes ra)
	{
			try {
			
			
			service.saveuser(user);
			//ra.addFlashAttribute("RegSucc" ,"You are Registered Succesfully.. Please Login to Continue..");
			String  FirstName = user.getFirstName();
			String LastNmae = 	user.getLastName();
			String email =	user.getEmail();
			
		
			
			String subject="Food-Nerd";
			String message=""
					+ "<div style='border:1px solid #e2e2e2; padding:20px;  margin-top: 250px; '>"
					+ "<h1>"
					+ "Registered Successfully"
					+ "<b>"+ " Enjoy Your Food" +"<br>"+"FirstName : "+  FirstName  +"<br>"+"LastName : "+  LastNmae+"<br>"
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

		
			
			return "redirect:/login";
			
			}catch (Exception e) {
				e.printStackTrace();
				ra.addFlashAttribute("RegFail" ,"Something went wrong.. Please Try Again..");
				
			}
			return "redirect:/reg";

		
			/*
			 * service.saveuser(user); return "redirect:/login";
			 */
	}

	// controller to validate role base user
	@RequestMapping("/rolelogin")
	public ModelAndView processLogin(@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password, HttpSession session,Model model,HttpServletRequest request ,RedirectAttributes rb) {
		try {
		User user = service.authenticateUser(email, password);
		System.out.println("user :"+user);
		session.setAttribute("userId", user.getUserId());

		System.out.println(user);

		if (user != null) {
			if (user.getRole().equalsIgnoreCase("Customer")) { // HttpSession session = hs.getAttribute(
				// user.getEmail());
					// String Umail=(String) session.getAttribute("Uemail");
					// session.setAttribute(Umail, email);
				session = request.getSession();
				session.setAttribute("userId", user.getUserId());
				session.setAttribute("useremail", user.getEmail());
				
					// System.out.println("Login Mail "+Umail);

				/* User user2 = service.getUserById(0) */
				ModelAndView mv = new ModelAndView("/Customer");
				/* model.addAttribute("showcards", RestService.getallRestaurants()); */
				mv.addObject("showcards", RestService.getallRestaurants()); 
				mv.addObject("user", user);
				
				
				
				return mv;
				
				/*
				 * return new ModelAndView("/Customer");
				 */
			}

			else if (user.getRole().equalsIgnoreCase("Restaurant")) {

				session = request.getSession();
				session.setAttribute("RestName", user.getRestaurant().getRestaurantName());
				session.setAttribute("RestId", user.getRestaurant().getRestaurantId());
				session.setAttribute("useremail", user.getRestaurant().getRestaurantId());
				// int userId= (int)session.getAttribute("userId");
				// System.out.println("session user id "+userId);
				
				return new ModelAndView("/RestaurantDashboard");
			}
				else return new ModelAndView("redirect:/login");
			}
			}catch (Exception e) {
			e.printStackTrace();
			
			//rb.addFlashAttribute("RegFail" ,"Something went wrong.. Please Try Again..");
			return new ModelAndView("redirect:/invalid_User");
		}
		
		return new ModelAndView("redirect:/reg");
	}

	
 
	
	
}
