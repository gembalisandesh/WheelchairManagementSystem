package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.ENUM.RequestStatus;
import com.springboot.ENUM.UserRole;
import com.springboot.model.User;
import com.springboot.service.RequestService;
import com.springboot.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RequestService requestService;

    @GetMapping("/home")
    public String showAdminHomePage(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "admin-home";
    }

    @PostMapping("/update-user-role")
    public String updateUserRole(@RequestParam("userId") Long userId, @RequestParam("role") UserRole role) {
        userService.updateUserRole(userId, role);
        return "redirect:/admin/home";
    }

    @PostMapping("/update-request-status")
    public String updateRequestStatus(@RequestParam("requestId") Long requestId, @RequestParam("status") RequestStatus status) {
        requestService.updateStatus(requestId, status);
        return "redirect:/admin/home";
    }

}