package com.example.demo.modal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modal.User;
import com.example.demo.repority.service.CustomUserDetailsService;

@Controller
public class LoginController {

	    @Autowired
	    private CustomUserDetailsService userService;

	    @GetMapping("/signup")
	    public String showSignupForm(Model model) {
	        model.addAttribute("user", new User());
	        return "signup";
	    }

	    @PostMapping("/signup")
	    public String signup(@ModelAttribute User user) {
	    	user.setEmail(user.getUsername());
	        userService.saveUser(user);
	        return "redirect:/login";
	    }

	    @GetMapping("/login")
	    public String showLoginForm() {
	        return "login";
	    }
	    
	    @GetMapping("/home")
	    public String showHomePage(Model model) {
	        return "home";
	}
}
