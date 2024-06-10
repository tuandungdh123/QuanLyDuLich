package com.example.qldl.Api;

import com.example.qldl.Entity.CarEntity;
import com.example.qldl.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/car-api")
public class CarApi {
    @Autowired
    private CarService carService;

    @GetMapping("/getAllCar")
    public ResponseEntity<?> getAllCar(){
        Map<String, Object> result = new HashMap<>();
        result.put("status", true);
        result.put("message", "thành công");
        result.put("data", carService.getAllCar());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/getSaveCar")
    public ResponseEntity<?> getSaveCar(@RequestBody CarEntity carEntity){
        Map<String, Object> result = new HashMap<>();
        CarEntity SaveCar = carService.getSaveCar(carEntity);
        result.put("status", true);
        result.put("message", "thành công");
        result.put("data", SaveCar);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/getDeleteCar")
    public ResponseEntity<?> getDeleteCar(@RequestParam ("carId") Integer carId){
        Map<String, Object> result = new HashMap<>();
        carService.getDeleteCar(carId);
        result.put("status", true);
        result.put("message", "thành công");
        result.put("data", "xóa thành công");
        return ResponseEntity.ok(result);
    }
}
