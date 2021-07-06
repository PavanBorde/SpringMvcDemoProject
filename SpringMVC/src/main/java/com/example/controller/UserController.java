package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.models.User;

@Controller
@RequestMapping("/")
public class UserController {

	
	public String displayLogin(Model model) {
		
		User user = new User();
		model.addAttribute("user",user);
		return "login";
	}
	
	
}
