package com.telu_pjj.manajemen_klinik_hewan.controller;

import com.telu_pjj.manajemen_klinik_hewan.model.User;
import com.telu_pjj.manajemen_klinik_hewan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String register() {
        return "register"; // returns the register.html Thymeleaf template
    }

    @PostMapping
    public ModelAndView handleRegistration(@RequestParam String username,
                                           @RequestParam String password,
                                           @RequestParam String confirmPassword) {
        ModelAndView modelAndView = new ModelAndView();
        
        // Basic validation for password confirmation
        if (!password.equals(confirmPassword)) {
            modelAndView.setViewName("register"); // Redirect back to registration
            modelAndView.addObject("error", "Passwords do not match.");
            return modelAndView;
        }

        // Check if the user already exists
        if (userRepository.findByUsername(username) != null) {
            modelAndView.setViewName("register"); // Redirect back to registration
            modelAndView.addObject("error", "Username already exists.");
            return modelAndView;
        }

        // Create a new User object and save it
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password)); // Store the hashed password
        userRepository.save(user);
        
        // Redirect to login page or other
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }
}