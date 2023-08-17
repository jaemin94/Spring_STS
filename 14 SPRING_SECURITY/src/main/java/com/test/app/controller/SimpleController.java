package com.test.app.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SimpleController {

	
	@GetMapping("/user")
	public void user(Authentication authentication)
	{
		log.info("GET / user");
		System.out.println("Authentication : "  + authentication);
		System.out.println("Authentication.getName : "  + authentication.getName());
		System.out.println("Authentication.getPrincipal : "  + authentication.getPrincipal());
		System.out.println("Authentication.getAuthorities : "  + authentication.getAuthorities());
		System.out.println("Authentication.getDetails : "  + authentication.getDetails());
		System.out.println("Authentication.getCredentials : "  + authentication.getCredentials());
	}
	
	@GetMapping("/member")
	public void member()
	{
		log.info("GET / member");
	}
	
	@GetMapping("/admin")
	public void admin()
	{
		log.info("GET / admin");
	}
	
	@GetMapping("/myLogin")
	public void myLogin()
	{
		log.info("GET / myLogin");
	}
	
	@GetMapping("/error")
	public void error()
	{
		log.info("GET / error");
	}
}
