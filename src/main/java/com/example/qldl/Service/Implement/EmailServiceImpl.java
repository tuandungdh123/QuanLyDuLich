package com.example.qldl.Service.Implement;

import com.example.qldl.Service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {


    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void SendFilePDF(String to, byte[] fileBytes){
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom("tuandungtruong122@gmail.com");
            helper.setTo(to);
            String title = "Xin chào chúng tôi đến từ Hội Người Thiếu Ngủ AnhDev";
            String content = "<div style='background-color: #d4edda;\n" +
                    "color: #155724;\n" +
                    "border: 1px solid #c3e6cb;\n" +
                    "border-radius: 5px;\n" +
                    "padding: 20px;\n" +
                    "margin-bottom: 20px;'>\n" +
                    "<h1><strong>Cảm ơn "+ to +" đã sử dụng dịch vụ bên tôi</strong></h1>" +
                    "</div>";
            helper.addAttachment("BillDatTour.pdf", new ByteArrayResource(fileBytes));
            helper.setSubject(title);
            helper.setText(content, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Could not send email", e);
        }
    }
}
