package com.example.qldl.Service;


public interface EmailService {
    void SendFilePDF(String to, byte[] fileBytes);
}
