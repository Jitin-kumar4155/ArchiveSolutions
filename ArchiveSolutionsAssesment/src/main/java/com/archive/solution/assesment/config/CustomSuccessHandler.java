package com.archive.solution.assesment.config;

import java.io.IOException;

import com.archive.solution.assesment.service.DefaultUserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.archive.solution.assesment.dao.UserRepository;
import com.archive.solution.assesment.dto.UserRegisteredDTO;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler{

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	DefaultUserService userService;
		
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		String redirectUrl = null;
		if(authentication.getPrincipal() instanceof DefaultOAuth2User) {
		DefaultOAuth2User  userDetails = (DefaultOAuth2User ) authentication.getPrincipal();
         String username = userDetails.getAttribute("email") !=null?userDetails.getAttribute("email"):userDetails.getAttribute("login")+"@gmail.com" ;
          if(userRepo.findByEmail(username) == null) {
        	  UserRegisteredDTO user = new UserRegisteredDTO();
        	  user.setEmail_id(username);
        	  user.setName(userDetails.getAttribute("email") !=null?userDetails.getAttribute("email"):userDetails.getAttribute("login"));
        	  user.setPassword(("Dummy"));
        	  user.setRole("USER");
        	  userService.save(user);
          }
		}  redirectUrl = "/dashboard";
		new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
	}

}
