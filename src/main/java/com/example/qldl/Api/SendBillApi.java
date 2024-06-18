package com.example.qldl.Api;

import com.example.qldl.Service.EmailService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Controller
@RestController
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/send-bill-api")
public class SendBillApi {
    @Autowired
    private EmailService emailService;

    @PostMapping("/SendBillPdf")
    public ResponseEntity<?> sendBillPdf(@RequestParam("file") MultipartFile file, @RequestParam("email") String email) {
        try {
            byte[] fileBytes = file.getBytes();
            emailService.SendFilePDF(email, fileBytes);
            return ResponseEntity.ok().body("{\"ok\":true}");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"ok\":false}");
        }
    }
}
