package com.example.vaidya.web.dto;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.example.vaidya.model.UserLogin;
import com.example.vaidya.repo.UserLogRepo;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/pat_log")
public class UserLogController {

	@Autowired
	private UserLogRepo urepo;
	
	public UserLogController(UserLogRepo urepo) {
		super();
		this.urepo = urepo;
	}

	@GetMapping("/pat_log")
	public String pat_log(Model model) {
		UserLogin patlog = new UserLogin();
		model.addAttribute("patlog",patlog);
		return "pat_log";
	}
	
	@PostMapping("/patientlogin")
	public String loginpat(@RequestParam("username1") String username1,Model model, @ModelAttribute("patlog") UserLogin patlog) {
		
		String username = patlog.getUsername();
		
		Optional<UserLogin> userdata = urepo.findById(username);
		if(patlog.getPasssword().equals(userdata.get().getPasssword())) {
			model.addAttribute("username1",username);
			return "index_chat";
		}
		else 
		{
			return "pat_log";
		}
	}
	
}
