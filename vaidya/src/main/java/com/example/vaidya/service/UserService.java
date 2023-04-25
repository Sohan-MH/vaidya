package com.example.vaidya.service;

import com.example.vaidya.model.User;
import com.example.vaidya.repo.UserRepo;
import com.example.vaidya.web.dto.UserRegistrationDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface UserService {

    User save(UserRegistrationDto registrationDto);


}

