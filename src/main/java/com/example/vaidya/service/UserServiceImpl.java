package com.example.vaidya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vaidya.model.User;
import com.example.vaidya.repo.UserRepo;
import com.example.vaidya.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService{

    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        super();
        this.userRepo = userRepo;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user  = new User(registrationDto.getUsername(),registrationDto.getFullname(),registrationDto.getPhone_num(),registrationDto.getAge(),registrationDto.getPasssword(),
                registrationDto.getGender(),registrationDto.getEmail());

        return userRepo.save(user);
    }



}
