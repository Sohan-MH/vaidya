package com.example.vaidya.web.dto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cont")
public class ContactController {

    @GetMapping
    public String ContactController(){
        return "contact";
    }
}
