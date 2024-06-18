package com.example.qldl.Api;


import com.example.qldl.Entity.TourE;
import com.example.qldl.Service.TourService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/home/tour-api")
public class TourApi {

    @Autowired
    private TourService tourService;


    @GetMapping("/getAllTour")
    public ResponseEntity<?> doGetAllTour(){
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("status", true);
            result.put("message", "Get All Account Success");
            result.put("data", tourService.getAllTour());
        } catch (Exception e){
            result.put("status", false);
            result.put("message", "Get All Account Fail");
            result.put("data", null);
            log.error("Fail When Call API /java05/account-api/getAllAccount ", e);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getTourByTourID")
    public ResponseEntity<?> doGetTourByTourID(@RequestParam("tourID") Integer tourID){
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("status", true);
            result.put("message", "Get All Account Success");
            result.put("data", tourService.getTourEByTourId(tourID));
        } catch (Exception e){
            result.put("status", false);
            result.put("message", "Get All Account Fail");
            result.put("data", null);
            log.error("Fail When Call API /java05/tour-api/getTourByTypeId ", e);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getTourByTypeID")
    public ResponseEntity<?> doGetTourByTypeID(@RequestParam("type_ID") Integer type_ID){
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("status", true);
            result.put("message", "Get All Account Success");
            result.put("data", tourService.getToursByTypeId(type_ID));
        } catch (Exception e){
            result.put("status", false);
            result.put("message", "Get All Account Fail");
            result.put("data", null);
            log.error("Fail When Call API /java05/tour-api/getTourByTypeId ", e);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping ("/getSaveTour")
    public ResponseEntity<?> doGetSaveTour(@RequestBody TourE tourE){
        Map<String, Object> result = new HashMap<>();
        try {
            TourE savTourE = tourService.addTour(tourE);
            result.put("status", true);
            result.put("message", "Get All Account Success");
            result.put("data", savTourE);
        } catch (Exception e){
            result.put("status", false);
            result.put("message", "Get All Account Fail");
            result.put("data", null);
            log.error("Fail When Call API /java05/tour-api/getTourByTypeId ", e);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping ("/getDeleteTour")
    public ResponseEntity<?> doPostDeleteTourTourID(@RequestParam("tourID") Integer tourID){
        Map<String, Object> result = new HashMap<>();
        try {
            tourService.doGetDeleteTour(tourID);
            result.put("status", true);
            result.put("message", "Get All Account Success");
            result.put("data", "Delete success");
        } catch (Exception e){
            result.put("status", false);
            result.put("message", "Get All Account Fail");
            result.put("data", null);
            log.error("Fail When Call API /java05/tour-api/getTourByTypeId ", e);
        }
        return ResponseEntity.ok(result);
    }
}
