package org.example.blog_page_task.dtos.authdtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private String passwordRepeat;
}
