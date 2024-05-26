package org.example.blog_page_task.dtos.userdtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAddRoleDto {
    private String email;
    private Long roleId;
}
