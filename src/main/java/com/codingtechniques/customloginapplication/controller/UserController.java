package com.codingtechniques.customloginapplication.controller;

import com.codingtechniques.customloginapplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class UserController {

    private UserService userService;
    @GetMapping("/home")
    public String home(){
        return "Home";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String registerSave(){
        return "register";
    }
}
