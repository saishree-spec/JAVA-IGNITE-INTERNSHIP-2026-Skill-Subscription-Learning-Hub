package com.skills.hub.controller;

import com.skills.hub.model.User;
import com.skills.hub.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*
=========================================================
WHAT IS THIS FILE?
Handles user actions like register and login
=========================================================
*/

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterPage() {

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {

        User registeredUser = userService.registerUser(user);

        if (registeredUser != null) {
            return "redirect:/login";
        }

        return "register";
    }

    @GetMapping("/login")
    public String showLoginPage() {

        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password) {

        User user = userService.login(email, password);

        if (user != null) {
            return "redirect:/packs";
        }

        return "login";
    }

    public UserService getUserService() {
        return userService;
    }
}