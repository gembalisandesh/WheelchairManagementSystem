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
import com.springboot.model.Request;
import com.springboot.service.RequestService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private RequestService requestService;

    @GetMapping("/home")
    public String showEmployeeHomePage(Model model) {
        List<Request> requests = requestService.findByStatus(RequestStatus.NEW);
        model.addAttribute("requests", requests);
        return "employee-home";
    }

    @GetMapping("/request-details")
    public String showRequestDetails(@RequestParam("requestId") Long requestId, Model model) {
        Request request = requestService.findById(requestId);
        model.addAttribute("request", request);
        return "request-details";
    }

    @PostMapping("/update-request-status")
    public String updateRequestStatus(@RequestParam("requestId") Long requestId, @RequestParam("status") RequestStatus status) {
        requestService.updateStatus(requestId, status);
        return "redirect:/employee/home";
    }

}