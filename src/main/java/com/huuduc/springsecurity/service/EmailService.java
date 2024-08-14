package com.huuduc.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    void sendMail(String to,String subject,String body);
}
