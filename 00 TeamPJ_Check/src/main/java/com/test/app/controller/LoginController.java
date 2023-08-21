package com.test.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {



	@GetMapping("/member/auth/Login")
	public void myLogin()
	{
		log.info("GET /member/auth/Login");
		
	}

	@GetMapping("/user")
	public void user()
	{
		log.info("GET / user");
	}
	
	@GetMapping("/Main")
	public void Main()
	{
		log.info("GET / Main");
	}
	
	@GetMapping("/error")
	public void error()
	{
		log.info("GET / error");
	}
}
