package org.example.blog_page_task.services.impl;

import org.example.blog_page_task.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;
    @Override
    public void sendConfirmationEmail(String email, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("norris63@ethereal.email");
        message.setTo("norris63@ethereal.email");
        message.setSubject("Confirm Email");
        message.setText("salam");
        //http://localhost:9090/auth/confirm?email=gulnar@itbrains.edu.az&token=asjdfnsjkf
        //template literals
        String res = "http://localhost:8080/auth/confirm?email="+email+"&token="+token;
        message.setText(res);
        mailSender.send(message);
    }
}
