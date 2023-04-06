package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.UserDetails;
import com.springboot.service.impl.UserDetailsServiceImpl;

@RestController
@RequestMapping("/api/user-details")
public class UserDetailsController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping("/{email}")
    public UserDetails getUserDetailsByEmail(@PathVariable String email) {
        return userDetailsService.loadUserByUsername(email);
    }

}