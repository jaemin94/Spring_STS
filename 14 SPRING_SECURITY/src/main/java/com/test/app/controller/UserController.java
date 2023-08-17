package com.test.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.app.domain.dto.UserDto;
import com.test.app.domain.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService service;
	
	@GetMapping("/join")
	public void join()
	{
		log.info("GET/join");
	}
	
	@PostMapping("/join")
	public String Userjoin(UserDto dto) 
	{
		log.info("POST/join : " + dto);
		
		// 01
		
		// 02
		
		// 03
		service.userJoin(dto);
		
		// 04
		return "redirect:myLogin?msg=Join_Success!";
	}
	
	
	
}
