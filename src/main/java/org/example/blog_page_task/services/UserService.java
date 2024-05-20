package org.example.blog_page_task.services;

import org.example.blog_page_task.dtos.authdtos.RegisterDto;

public interface UserService {
    boolean register(RegisterDto registerDto);
    boolean confirmEmail(String email, String token);
}
