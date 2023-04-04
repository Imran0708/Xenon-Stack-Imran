package com.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.UserDto;
import com.entity.BillingDetails;
import com.entity.FoodMenu;
import com.entity.Restaurant;
import com.entity.User;
import com.repository.RestaurantRepository;
import com.service.BillDetailsService;
import com.service.MenuService;
import com.service.RestaurantService;
import com.service.UserService;

@Controller
public class RestaurantController {

private UserService userServ;
	
	@Autowired
	private RestaurantService resService;

	@Autowired
	private RestaurantRepository repository;

	
	@Autowired
	MenuService menuService;
	
	
	
	@Autowired
	BillDetailsService billservice;
	
	
	
	
	
	
	  @GetMapping("/RestaurantDashboard")
	  public String RestaurantHome() { 
		  return "RestaurantDashboard";
	  
	  }
	 
	
	
	// show restraurant
		@RequestMapping(value="/showu", method = RequestMethod.GET)
		public String servicesList(Model model) {
		    model.addAttribute("list1", resService.getallRestaurants());
		    return "ShowRestaurant";
		}
		
		
	
		  @GetMapping("/MenuAdd") 
		  public String addmenu()
		  {
		    	return "MenuAdd";  
		  }
		 
		  
//		  save new menu for restaurant
		  @PostMapping("/savemenu")
			public String addmenu(@ModelAttribute("menulist") FoodMenu menu,HttpSession session)
			{
				/*
				 * int userid = (int)session.getAttribute("userId"); System.out.println(userid);
				 */
			  
			  	int restId = (int)session.getAttribute("RestId");
			  	System.out.println("my rest id"+restId);

			  
			  	Restaurant restobj =  resService.getRestaurantById(restId);
			  	
				/*
				 * int restid = restobj.getRestaurantId(); System.out.println(restid);
				 */
			  	menu.setRestaurantId(restId);
			  	menuService.addmenu(menu);
				
				return "redirect:/ShowMenu";
				
			}
		  
			/*
			 * @GetMapping("/showmenu/{id}")
			 *  public String Shomenu(@PathVariable (value ="id") int id, Model model,HttpSession session) {
			 * System.out.println("menu id is"+id);
			 * 
			 * model.addAttribute("shopcard", menuService.getMenuById(id)); return
			 * "viewProduct"; 
			 * }
			 */
		  
		  
		  @RequestMapping(value="/ShowMenu",method=RequestMethod.GET)
		  	public String ShowMenu(Model model, HttpSession session)
		  	{
		  		//int RestId = (int)session.getAttribute("RestId");
		  	  	//System.out.println("my rest show"+RestId);
		  		List<FoodMenu> list1=this.menuService.getallMenus();
		  		model.addAttribute("list1",list1);
		  	
				return "RestaurantDashboard";
		  		
		  	}



		  
		  //show menu on the cart page
			
		  @GetMapping("/showmenu/{id}")
			public String Shomenu(@PathVariable (value = "id") int id,   Model model) {
			    System.out.println("menu id is"+id);
				model.addAttribute("shopcard", menuService.getMenuById(id));
			    return "viewProduct";
			}


		  	
		  	
		  	
		  	
//		  	Update Menu
		
		  	@GetMapping("/updateMenu/{id}")
			public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {
				
				// get employee from the service
				FoodMenu foodmenu = menuService.UpdateMenu(id);
				
				
				// set employee as a model attribute to pre-populate the form
				model.addAttribute("reasturant", foodmenu);
				return "updateMenu";
			}
		  	
		  	

			
		  


// Delete Menu 
		
		
		
			  	@GetMapping("/deleteMenu/{id}")
				public String deletereasturant(@PathVariable (value = "id") int id) {
					
					// call delete employee method 
					this.menuService.deleteReasurantById(id);
					return "redirect:/ShowMenu";
				}

			  	
			  	
			  //this is for viewing placed orders in restaurant dashboard
				@GetMapping("/vieworders")
				public String ViewOrders(Model model) {
					
					 List<BillingDetails> orderList = billservice.getAllOrders();
					 System.out.println(orderList);
					model.addAttribute("orders", orderList);
					return "ViewOrdersRestaurant";
					
					
				}
				
				//this is for viewing placed orders in User dashboard
				@GetMapping("/viewuserorders")
				public String ViewUserOrder(Model model) {
					 List<BillingDetails> orderList = billservice.getAllOrders();
					 System.out.println(orderList);
					model.addAttribute("orders", orderList);
//					model.addAttribute("orders", orderList);
					return "ViewUserOrder";
					
					
				}

				
}
