package com.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.ENUM.UserRole;
import com.springboot.model.User;
import com.springboot.service.UserService;



@Controller
public class LoginController {
	@Autowired
    private UserService userService;


    @GetMapping("/login")
    public String showLoginForm() {
        return "login-form";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration-form";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration-form";
        }
        user.setRole(UserRole.CUSTOMER);
        userService.save(user);
        return "redirect:/login?registrationSuccess";
    }

}