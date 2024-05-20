package org.example.blog_page_task.services;

public interface EmailService {
    void sendConfirmationEmail(String email, String token);
}
