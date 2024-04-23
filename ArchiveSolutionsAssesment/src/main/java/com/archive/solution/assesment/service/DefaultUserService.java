package com.archive.solution.assesment.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.archive.solution.assesment.dto.UserRegisteredDTO;
import com.archive.solution.assesment.model.User;


public interface DefaultUserService extends UserDetailsService{

	User save(UserRegisteredDTO userRegisteredDTO);

}
