package com.example.qldl.Api;


import com.example.qldl.Service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/typeTour-api")
@RequiredArgsConstructor
public class TypeTourApi {
    @Autowired
    private TourService tourService;

    @GetMapping("/getAllTypeTour")
    public ResponseEntity<?> doGetAllTypeTour(){
        Map<String, Object> result = new HashMap<>();
        result.put("success",true);
        result.put("message","Call Api Success");
        result.put("data",tourService.getAllTypeTourE());
        return ResponseEntity.ok(result);
    }
}
