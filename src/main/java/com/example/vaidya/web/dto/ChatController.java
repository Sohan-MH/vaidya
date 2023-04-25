package com.example.vaidya.web.dto;

import com.example.vaidya.model.User;
import com.example.vaidya.model.UserLogin;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {
    @GetMapping
    public String ContactController(Model model){
        return "index_chat";
    }
}




