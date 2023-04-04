package com.controller;
import java.util.Random;

import javax.mail.Message;
import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.entity.User;
import com.repository.UserRepository;
import com.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ForgotPassword 
{Random random = new Random(1000);

@Autowired
private EmailService emailService;

@Autowired
private UserRepository userRepository;


	// email id form open handler
	@RequestMapping("/forgotp")
	public String openEmailForm() {
		return "forgot_email_form";
	
	}
	
		// email id form open handler
		@PostMapping("/Send_Otp")
		public String Send_Otp(@RequestParam("email")String email,HttpSession session) {
			System.out.println("email: "+ email);
			User user = this.userRepository.getUserByEmail(email);
			if (user==null) {
				return"Invalid_Details";
			}else {
			
			int otp = random.nextInt(9999999);
			System.out.println("OTP :"+ otp);
			
			// send Otp to email
			String subject = "OTP Form CK";
			String message="<h1> OTP="+otp+ "</h1>";
			String to =email;
		
			boolean flag= this.emailService.sendEmail(subject,message,to);
			if(flag)
			{
				session.setAttribute("myotp", otp);
				session.setAttribute("email", email);
				return "verify-otp";
				
			}else
			{
				session.setAttribute("message","Check your Email");
				return "forgot_email_form";
			}
			}
			 
				
				
		}
		//Verify OTP
		@RequestMapping("/verify_otp")
		public String  verify_otp(@RequestParam("otp") int otp,HttpSession session,Model model,HttpServletRequest request ) {
		int myOtp=(int)session.getAttribute("myotp");
		System.out.println("myotp: "+ myOtp);
		System.out.println("otp: "+ otp);
		
		if(myOtp==otp) {
			//Password change form
			return "paasword_change_form";
		}else {
			return "incorrect-otp";
		}
		}
		@RequestMapping("/change-password")
		public String  changePassword(@RequestParam("newpassword") String newpassword,HttpSession session,Model model,HttpServletRequest request ) {
			
			String email=(String)session.getAttribute("email");
			User user=this.userRepository.getUserByEmail(email);
			user.setPassword(newpassword);
			this.userRepository.save(user);
			return "redirect:/login?change=password change successfully...";
			
			
			
		}
		
		}
			
		
			
			
	
