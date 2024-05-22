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
    public String getHomeView(){ return "pages/Home/Home"; }
    @GetMapping("/tour")
    public String getTourView(){
        return "pages/Detail/TourDetail";
    }
    @GetMapping("/list")
    public String getListTourView(){
        return "pages/Detail/DanhSanhTour";
    }
    @GetMapping("/tourcart")
    public String getTourCartView(){ return "pages/Detail/TourCart"; }
    @GetMapping("/BookingVe")
    public String getBookVe(){
        return "pages/BookVe/BookVe";
    }
    @GetMapping("/Footer")
    public String getFooter(){return "pages/Footer/Footer";}
    @GetMapping("/Hotel")
    public String getThueXeView(){return "pages/Hotel/Hotel";}
    @GetMapping("/xe")
    public String getHotel(){return "pages/ThueXe/ThueXe";}
    @GetMapping("/admin")
    public String getAdmin(){return "pages/Admin/Admin";}
}
