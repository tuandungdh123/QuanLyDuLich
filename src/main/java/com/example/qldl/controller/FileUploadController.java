package com.example.qldl.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RestController
@RequestMapping("/upload-api")
public class FileUploadController {

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // Đường dẫn tới thư mục images trong src/main/resources
            String uploadDir = "src/main/resources/static/images/imagesTour2/";

            // Tạo đường dẫn đầy đủ tới file
            Path upload = Paths.get(uploadDir);
            if(!Files.exists(upload)){
                Files.createDirectories(upload);
            }
            // Lưu file vào vị trí được chỉ định
            Path filPath = upload.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), filPath);

            return ResponseEntity.ok().body("File uploaded successfully!");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while uploading the file: " + e.getMessage());
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing the request: " + e.getMessage());
    }
}