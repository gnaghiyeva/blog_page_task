package org.example.blog_page_task.services.impl;

import org.example.blog_page_task.dtos.authdtos.RegisterDto;
import org.example.blog_page_task.dtos.userdtos.UserAddRoleDto;
import org.example.blog_page_task.dtos.userdtos.UserDashboardListDto;
import org.example.blog_page_task.dtos.userdtos.UserDto;
import org.example.blog_page_task.models.Role;
import org.example.blog_page_task.models.UserEntity;
import org.example.blog_page_task.repositories.RoleRepository;
import org.example.blog_page_task.repositories.UserRepository;
import org.example.blog_page_task.services.EmailService;
import org.example.blog_page_task.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private EmailService emailService;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public boolean register(RegisterDto register) {
        UserEntity user = userRepository.findByEmail(register.getEmail());
        if (user != null) {
            return false;
        }
        String hashPassword = bCryptPasswordEncoder.encode(register.getPassword());
        Random random = new Random();
//      String token = String.valueOf(random.nextInt(26,30));
        String token = bCryptPasswordEncoder.encode(register.getEmail());
        UserEntity newUser = modelMapper.map(register, UserEntity.class);
        newUser.setEmailConfirmed(false);
        newUser.setConfirmationToken(token);
        newUser.setPassword(hashPassword);
        userRepository.save(newUser);
        emailService.sendConfirmationEmail(register.getEmail(), token);
        return true;
    }

    @Override
    public boolean confirmEmail(String email, String token) {
        UserEntity findUser = userRepository.findByEmail(email);
        if(findUser.getConfirmationToken().equals(token) && findUser!=null){
            findUser.setEmailConfirmed(true);
            userRepository.save(findUser);
            return true;
        }
        return false;
    }

    @Override
    public List<UserDashboardListDto> getDashboardUsers() {
        List<UserEntity> findUsers = userRepository.findAll();
        List<UserDashboardListDto> users = findUsers.stream().map(user->modelMapper.map(user, UserDashboardListDto.class)).collect(Collectors.toList());
        return users;
    }

    @Override
    public UserDto getUserById(Long id)
    {
        UserEntity findUser = userRepository.findById(id).orElseThrow();
        UserDto user = modelMapper.map(findUser, UserDto.class);
        return user;
    }

    @Override
    public void addRole(UserAddRoleDto userAddRole) {
        UserEntity findUser = userRepository.findByEmail(userAddRole.getEmail());
        List<Role> roles = roleRepository.findAll().stream().filter(x->x.getId() == userAddRole.getRoleId()).collect(Collectors.toList());
        findUser.setRoles(roles);
        userRepository.save(findUser);

    }

}
