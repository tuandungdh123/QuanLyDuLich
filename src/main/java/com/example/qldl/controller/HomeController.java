package com.example.qldl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @GetMapping({"/","/login"})
    public String getLogin(){
        return "Login";
    }
    @GetMapping("/nav")
    public String getPageView(){
        return "pages/Navbar/Navbar";
    }
}
