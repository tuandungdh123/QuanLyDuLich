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
    @GetMapping("/home")
    public String getHomeView(){
        return "pages/Home/Home";
    }
    @GetMapping("/tour")
    public String getTourView(){
        return "pages/Detail/TourDetail";
    }
    @GetMapping("/BookingVe")
    public String getBookVe(){
        return "pages/BookVe/BookVe";
    }
    @GetMapping("/Footer")
    public String getFooter(){return "pages/Footer/Footer";}
    @GetMapping("/Hotel")
    public String getHotel(){return "pages/Hotel/Hotel";}
    @GetMapping("/admin")
    public String getAdmin(){return "pages/Admin/Admin";}
}
