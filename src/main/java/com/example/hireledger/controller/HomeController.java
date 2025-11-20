package com.example.hireledger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/admin")
    public String adminTest() {
        return "admin";
    }

    @GetMapping("/denied")
    public String denied() {
        return "denied";
    }

    @GetMapping("/user")
    public String userTest() {
        return "user";
    }

    @GetMapping("/error")
    public String error(@RequestParam(value = "message", required = false) String message, Model model) {
        model.addAttribute("errorMessage", message != null ? message : "An error occurred");
        return "error";
    }

}
