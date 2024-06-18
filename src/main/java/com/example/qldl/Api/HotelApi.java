package com.example.qldl.Api;

import com.example.qldl.Entity.HotelEntity;
import com.example.qldl.Service.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RestController
@RequestMapping("/home/hotel-api")

public class HotelApi {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/getAllHotel")
    public ResponseEntity<?> doGetAllHotel (){
        Map<String,Object> result = new HashMap<>();
        result.put("success",true);
        result.put("message","Call Api Success");
        result.put("data",hotelService.getAllHotel());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/getSaveHotel")
    public ResponseEntity<?> doGetSaveHotel (@RequestBody HotelEntity hotelEntity){
        Map<String,Object> result = new HashMap<>();
        result.put("success",true);
        result.put("message","Call Api Success");
        result.put("data",hotelService.getSaveHotel(hotelEntity));
        return ResponseEntity.ok(result);
    }

    @DeleteMapping ("/DeleteHotel")
    public ResponseEntity<?> doDeleteHotel (@RequestParam int hotelId){
        Map<String,Object> result = new HashMap<>();
        try {
            result.put("success",true);
            result.put("message","Call Api Success");
            hotelService.doDeleteHotel(hotelId);
        }
        catch (Exception e){
            result.put("success",false);
            result.put("message","Call Api Error");
            result.put("data",null);
            System.out.println(e);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getHotelByHotelId")
    public ResponseEntity<?> doGetHotelByHotelId(@RequestParam("hotelId") int hotelId){
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("status", true);
            result.put("message", "Get All Account Success");
            result.put("data", hotelService.getHotelByHotelId(hotelId));
        } catch (Exception e){
            result.put("status", false);
            result.put("message", "Get All Account Fail");
            result.put("data", null);
        }
        return ResponseEntity.ok(result);
    }


}
