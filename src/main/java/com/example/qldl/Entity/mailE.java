package com.example.qldl.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class mailE {
    @Value("${spring.mail.username}")
    String from = "tuandungtruong122@gmail.com";
    private String to;
    private String subject = "Chúc Mừng Bạn ";
    private String body = "Bạn đã đăng ký tài khoản thành công";
    List<String> cc = new ArrayList<>();
    List<String> bcc = new ArrayList<>();
    List<File> files = new ArrayList<>();

    public mailE(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }
}
