package com.example.qldl.Service.Implement;

import com.example.qldl.Entity.mailE;
import com.example.qldl.Service.mailService;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class mailServiceImpl implements mailService {
    private final JavaMailSender mailSender;
    @Override
    public void sendMail(mailE mail) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        helper.setTo(mail.getTo());
        helper.setFrom(mail.getFrom());
        helper.setSubject(mail.getSubject());
        helper.setText(mail.getBody());
        helper.setReplyTo(mail.getFrom());
        mailSender.send(message);
    }
}
