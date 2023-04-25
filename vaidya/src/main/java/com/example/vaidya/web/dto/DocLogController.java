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

import com.example.vaidya.model.DocLogin;
import com.example.vaidya.model.UserLogin;
import com.example.vaidya.repo.DocLogRepo;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/pat_log")
public class DocLogController {

	@Autowired
	private DocLogRepo drepo;

	public DocLogController(DocLogRepo drepo) {
		super();
		this.drepo = drepo;
	}

	@GetMapping("/d_login")
	public String doc_log(Model model) {
		DocLogin doctor = new DocLogin();
		model.addAttribute("doctor",doctor);
		return "doc_login";
	}

	@PostMapping("/doctorlogin")
	public String logindoc(@ModelAttribute("doctor") DocLogin doctor,Model model) {

		String UserName = doctor.getUserName();

		Optional<DocLogin> duserdata = drepo.findById(UserName);
		if(doctor.getDoc_Password().equals(duserdata.get().getDoc_Password())) {
			model.addAttribute("username1",UserName);
			return "index_chat_doc";
		} else {
			return "doc_login";
		}
	}

}
