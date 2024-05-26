package org.example.blog_page_task.dtos.userdtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String email;
    private String firstname;
    private String lastname;
}
