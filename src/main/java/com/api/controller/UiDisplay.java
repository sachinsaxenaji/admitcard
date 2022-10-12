package com.api.controller;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Optional;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.api.entity.Product;
import com.api.helper.Messeges;
import com.api.repo.ProductRepo;


@Controller
@RequestMapping("/user")

public class UiDisplay {
	
	@Autowired
	private ProductRepo productRepo;
	
	
	@RequestMapping("/rollno")
    public String user()
    {
    	
    	return "enterRoll";
    }
	
	
	@PostMapping("/submit")
    public String submit(@RequestParam("rolln") String rollN, HttpSession session, Model model)
    {
		
		 System.out.println(rollN);
		
		 
		 
		if(productRepo.getCardByRollNumber(rollN) == null)
				
				{
			 System.out.println("Please enter correct username");
			 session.setAttribute("message", new Messeges("Please enter correct roll no!", "alert-error"));

			 return "redirect:/user/rollno";
				}
		
		 Optional<Product> productOptional  =Optional.of(productRepo.getCardByRollNumber(rollN));
	
		 
		
		 Product product = productOptional.get();
		
	
			 session.setAttribute("rollN", rollN);
			 return "redirect:/user/index";
			
		
		 
    	
    }
	
	


	 	@GetMapping("/index")
	    public String user_dashboard(Model model, HttpSession session) throws UnsupportedEncodingException
	    {
		 
		 String rollN = (String) session.getAttribute("rollN");
		 System.out.println(rollN);
		 Optional<Product> productOptional  =Optional.of(productRepo.getCardByRollNumber(rollN));
		 Product product = productOptional.get();

		 String base64Encoded =Base64.getEncoder().encodeToString(product.getpic());
		 model.addAttribute("contentImages", base64Encoded );

		 System.out.println(product);
		 model.addAttribute("product", product);
		 
		 model.addAttribute("test", "are you working thymlfy");
	    	return "card";
	    }


}
