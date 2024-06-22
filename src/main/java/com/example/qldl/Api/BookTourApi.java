package com.example.qldl.Api;


import com.example.qldl.Entity.BookTourEntity;
import com.example.qldl.Service.BookTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
@RequestMapping("/BookTour")
public class BookTourApi {
    @Autowired
    private BookTourService bookTourService;

    @GetMapping("/GetAllBookTour")
    public ResponseEntity<?> GetAllBookTour() {
        Map<String, Object> result = new HashMap<>();
        result.put("status", true);
        result.put("message", "Success");
        result.put("data", bookTourService.GetAllInfoBookTour());
        return ResponseEntity.ok(result);
    }

    //Hàm Xóa
    @DeleteMapping("/GetDeleteBookTour")
    public ResponseEntity<?> doGetDeleteBookTour(@RequestParam("bookTourId") Integer bookTourId) {
        Map<String, Object> result = new HashMap<>();
        bookTourService.doGetDeleteBookTour(bookTourId);
        result.put("status", true);
        result.put("message", "Success");
        result.put("data", "success");
        return ResponseEntity.ok(result);
    }

    //    //Hàm sửa
//    @GetMapping("/GetUpdateBookTour")
//    public ResponseEntity<?> GetUpdateBookTour(@RequestBody BookTourEntity bookTourEntity) {
//        Map<String, Object> result = new HashMap<>();
//        BookTourEntity updateBookTourEntity = bookTourService.UpdateBookTour(bookTourEntity);
//        result.put("status", true);
//        result.put("message", "Success");
//        result.put("data", updateBookTourEntity);
//        return ResponseEntity.ok(result);
//    }
    //Hàm lưu
    @PostMapping("/saveBookTour")
    public ResponseEntity<?> saveBookTour(@RequestBody BookTourEntity bookTourEntity) {
        Map<String, Object> result = new HashMap<>();
        BookTourEntity savedEntity = bookTourService.saveBookTour(bookTourEntity);
        try {
            result.put("status", true);
            result.put("message", "Success");
            result.put("data", savedEntity);
        } catch (Exception e) {
            result.put("status", false);
            result.put("message", e.getMessage());
            result.put("data", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getBookTourByBookTourId")
    public ResponseEntity<?> doGetBookTourByBookTourId(@RequestParam ("bookTourId")Integer bookTourId ) {
        Map<String, Object> result = new HashMap<>();
        try{
            result.put("status", true);
            result.put("message", "Success");
            result.put("data", bookTourService.GetBookTourByBookTourId(bookTourId));
        }catch (Exception e){
            result.put("status", false);
            result.put("message", e.getMessage());
            result.put("data", null);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getBookTourByStatusID")
    public ResponseEntity<?> doGetBookTourByStatusID(@RequestParam ("status_Id")Integer status_Id ) {
        Map<String, Object> result = new HashMap<>();
        try{
            result.put("status", true);
            result.put("message", "Success");
            result.put("data", bookTourService.GetBookTourByStatusID(status_Id));
        }catch (Exception e){
            result.put("status", false);
            result.put("message", e.getMessage());
            result.put("data", null);
        }
        return ResponseEntity.ok(result);
    }
}