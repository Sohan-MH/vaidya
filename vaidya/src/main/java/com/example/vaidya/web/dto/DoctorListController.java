package com.example.vaidya.web.dto;

import com.example.vaidya.service.DoctorService;
import com.example.vaidya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doc_reg")

public class DoctorListController {

    @Autowired
    private DoctorService doctorService;


    public DoctorListController(DoctorService doctorService){
        super();
        this.doctorService = doctorService;
    }

    @GetMapping
    public String showRegistrationForm(){

        return "doc_registration";
    }
    @ModelAttribute("doctor")
    public  DoctorRegistrationDto doctorRegistrationDto(){
        return new DoctorRegistrationDto();
    }

    @PostMapping
    public String registerDocAccount(@ModelAttribute("doctor")DoctorRegistrationDto registrationDto){
        doctorService.save(registrationDto);
        return "redirect:/doc_reg";
    }

}







