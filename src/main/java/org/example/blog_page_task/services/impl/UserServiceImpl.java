package org.example.blog_page_task.services.impl;

import org.example.blog_page_task.dtos.authdtos.RegisterDto;
import org.example.blog_page_task.models.User;
import org.example.blog_page_task.repositories.UserRepository;
import org.example.blog_page_task.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public boolean register(RegisterDto register) {
        User user = userRepository.findByEmail(register.getEmail());
        if (user != null) {
            return false;
        }
        String hashPassword = bCryptPasswordEncoder.encode(register.getPassword());
        Random random = new Random();
//      String token = String.valueOf(random.nextInt(26,30));
        String token = bCryptPasswordEncoder.encode(register.getEmail());
        User newUser = modelMapper.map(register, User.class);
        newUser.setEmailConfirmed(false);
        newUser.setConfirmationToken(token);
        newUser.setPassword(hashPassword);
        userRepository.save(newUser);
        return true;
    }
}
