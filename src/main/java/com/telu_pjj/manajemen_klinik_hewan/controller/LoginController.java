package com.telu_pjj.manajemen_klinik_hewan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // returns the login.html Thymeleaf template
    }

    @PostMapping("/login")
    public ModelAndView handleLogin(@RequestParam String username, 
                                     @RequestParam String password) {
        // Logic for authenticating user
        // Example: authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        
        ModelAndView modelAndView = new ModelAndView();
        // Assuming successful authentication
        modelAndView.setViewName("redirect:/home"); // Redirect to home or desired page
        
        // Handle unsuccessful authentication (if applicable)
        // modelAndView.setViewName("login"); // Redirect back to login with an error message

        return modelAndView;
    }
}