package com.springboot.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.ENUM.RequestStatus;
import com.springboot.model.Request;
import com.springboot.service.RequestService;



@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private RequestService requestService;

    @GetMapping("/home")
    public String showCustomerHomePage(Model model, Principal principal) {
        String email = principal.getName();
        List<Request> requests = requestService.findByCustomerEmail(email);
        model.addAttribute("requests", requests);
        return "customer-home";
    }

    @GetMapping("/new-request")
    public String showNewRequestForm(Model model) {
        model.addAttribute("request", new Request());
        return "new-request-form";
    }

    @PostMapping("/new-request")
    public String processNewRequestForm(@Valid @ModelAttribute("request") Request request, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "new-request-form";
        }
        String email = principal.getName();
        request.setCustomerEmail(email);
        request.setStatus(RequestStatus.NEW);
        requestService.save(request);
        return "redirect:/customer/home";
    }

}