package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.User;
import com.repository.UserPayNgoRepository;
import com.repository.UserRepository;
import com.service.UserService;


@Controller
public class UserController 
{
//	controller method for home page
	@Autowired
	private UserService service;
	
	

	@Autowired
	private UserRepository repository;
	
	
	@Autowired
	private UserPayNgoRepository userPayNgoRepository;
	
	
	

	
//	 controller to insert data
	
	
	
	
	
	@GetMapping("/customer")
	public String CustomerHome() {
		
		return "Customer";
	}
	
	
//	view profile
	
	@GetMapping("/customerpro/{id}")
	public String viewHomePage(@PathVariable(value = "id") int UserId, Model model) {
		User user = service.getUserById(UserId);
		model.addAttribute("users", user);
		return "customerprofile";
	}

	// new update
	

	//post on update from
	  @PostMapping("/customerproupdate/{id}")
	  public String updateForm(@PathVariable(value="id") int UserId,Model model) {
	   User user = service.getUserById(UserId);
	   model.addAttribute("users",user);
	  return "customerproupdate";
	  }
	  
	  
	 
	  
	
	  @PostMapping("/update")
			public String updateproilfe(@ModelAttribute("users") User user, Model model,HttpSession session) {
		  //  this.service.saveuser(user);
//			  User user = service.getUserById(id);
//			  model.addAttribute("users", user);
	//
//				return "customerproupdate";
			  int userId = (int)session.getAttribute("userId");

			  user.setUserId(userId);
			  service.updateUser(user);
				System.out.println(user);
				return "redirect:/customerpro";

			}
	  
	  
	  
	  
	


	
	
	  
	  
	
	
	
	
	

}
