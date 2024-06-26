package org.example.blog_page_task.services;

import org.example.blog_page_task.dtos.authdtos.RegisterDto;
import org.example.blog_page_task.dtos.userdtos.UserAddRoleDto;
import org.example.blog_page_task.dtos.userdtos.UserDashboardListDto;
import org.example.blog_page_task.dtos.userdtos.UserDto;

import java.util.List;

public interface UserService {
    boolean register(RegisterDto registerDto);
    boolean confirmEmail(String email, String token);

    List<UserDashboardListDto> getDashboardUsers();
    UserDto getUserById(Long id);

    void addRole(UserAddRoleDto userAddRole);
}
