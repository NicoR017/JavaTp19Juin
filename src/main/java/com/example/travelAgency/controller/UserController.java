package com.example.travelAgency.controller;

import com.example.travelAgency.model.User;
import com.example.travelAgency.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/home";
        }
        return "login";
    }

    @GetMapping("/signup")
    public String displaySignup(User user) {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/signup";
        }
        userService.register(user);
        return "redirect:/login";
    }
  
    @GetMapping("/logout")
    public String logout(User user) {
        return "logout";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:flight/list";
    }
}
