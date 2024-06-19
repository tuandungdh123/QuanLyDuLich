package com.example.qldl.Api;

import com.example.qldl.Entity.CarRentalEntity;
import com.example.qldl.Service.CarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
@RequestMapping("/xe")
public class CarRentalApi {
    @Autowired
    private CarRentalService carRentalService;

    @GetMapping("/GetAllCarRental")
    public ResponseEntity<?> GetAllCarRental(){
        Map<String, Object> result = new HashMap<>();
        result.put("status", true);
        result.put("message", "Success");
        result.put("data", carRentalService.GetAllInfoCarRental());
        return ResponseEntity.ok(result);
    }

    //Hàm lưu
    @PostMapping("/saveCarRental")
    public ResponseEntity<?> saveCarRental(@RequestBody CarRentalEntity carRentalEntity){
        Map<String, Object> result = new HashMap<>();
        try{
            result.put("status", true);
            result.put("message", "Success");
            result.put("data", carRentalService.saveCarRental(carRentalEntity));
        } catch (Exception e){
            result.put("status", false);
            result.put("message", e.getMessage());
            result.put("data", null);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getCarRentalByCarId")
    public ResponseEntity<?> doGetCarRentalByCarId(@RequestParam ("rentalId")int rentalId) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("status", true);
            result.put("message", "Success");
            result.put("data", carRentalService.getCarRentalByCarId(rentalId));
        }catch (Exception e){
            result.put("status", false);
            result.put("message", e.getMessage());
            result.put("data", null);
        }
        return ResponseEntity.ok(result);
    }

}
