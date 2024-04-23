package com.archive.solution.assesment.controller;

import com.archive.solution.assesment.dao.AddUIRepository;
import com.archive.solution.assesment.dto.AddUIDTO;
import com.archive.solution.assesment.dto.UserLoginDTO;
import com.archive.solution.assesment.dto.UserRegisteredDTO;
import com.archive.solution.assesment.service.AddUIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.archive.solution.assesment.dao.UserRepository;


@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	@Autowired
	UserRepository userRepo;

	@Autowired
	AddUIService addUIService;

	public DashboardController(AddUIService addUIService) {
		super();
		this.addUIService = addUIService;
	}

	@ModelAttribute("AddUI")
	public AddUIDTO addUIDTODTO() {
		return new AddUIDTO();
	}

	@GetMapping
    public String displayDashboard(Model model){
		SecurityContext securityContext = SecurityContextHolder.getContext();
		if(securityContext.getAuthentication().getPrincipal() instanceof DefaultOAuth2User) {
		DefaultOAuth2User user = (DefaultOAuth2User) securityContext.getAuthentication().getPrincipal();
		model.addAttribute("userDetails", user.getAttribute("name")!= null ?user.getAttribute("name"):user.getAttribute("login"));
		}else {
			User user = (User) securityContext.getAuthentication().getPrincipal();
			com.archive.solution.assesment.model.User users = userRepo.findByEmail(user.getUsername());
			model.addAttribute("userDetails", users.getName());
		}
        return "AddUI";
    }
	@PostMapping
	public String addUIAndSave(@ModelAttribute("AddUI")
									  AddUIDTO addUIDTO) {
		addUIService.save(addUIDTO);
		return "list";
	}

	@GetMapping("/list")
	public String listUI(){
		return "list";
	}
}
