package com.example.vaidya.service;

import com.example.vaidya.model.Doctor;
import com.example.vaidya.repo.DoctorRepo;
import com.example.vaidya.web.dto.DoctorRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface DoctorService {
    Doctor save(DoctorRegistrationDto registrationDto);
}



