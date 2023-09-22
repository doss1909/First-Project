package com.das.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.das.entity.User;
import com.das.service.UserService;

@Controller
public class UserController {
	
	   @Autowired
	    private UserService userService;

	    @GetMapping("/register")
	    public String showRegistrationForm(Model model) {
	        model.addAttribute("user", new User());
	        return "signup";
	    }

	    @PostMapping("/register")
	    public String processRegistrationForm(@Valid User user, BindingResult bindingResult, Model model) {
	        if (bindingResult.hasErrors()) {
	            return "signup";
	        }
	        userService.saveUser(user);
	        return "/Succes";
	    }
	    
	    @GetMapping("/login")
	    public String showLoginForm(Model model) {
	        model.addAttribute("user", new User());
	        return "login";
	    }


	    @GetMapping("/edit-password")
	    public String showEditPasswordForm(Model model) {
	        model.addAttribute("user", new User());
	        return "edit-password";
	    }

	    @PostMapping("/login")
	    public String processLoginForm(@Valid User user, BindingResult bindingResult, Model model) {
	        if (bindingResult.hasErrors()) {
	            return "login";
	        }
	        User existingUser = userService.findByEmail(user.getEmail());
	        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
	            return "home";
	        } else {
	            model.addAttribute("error", "Invalid email or password.");
	            return "login";
	        }
	    }

	    @PostMapping("/edit-password")
	    public String processEditPasswordForm(@Valid User user, BindingResult bindingResult, Model model) {
	        if (bindingResult.hasErrors()) {
	            return "edit-password";
	        }
	        User existingUser = userService.findByEmail(user.getEmail());
	        if (existingUser != null) {
	            existingUser.setPassword(user.getPassword());
	            userService.saveUser(existingUser);
	            return "password-updated";
	        } else {
	            model.addAttribute("error", "User not found.");
	            return "edit-password";
	        }
	    }
}
