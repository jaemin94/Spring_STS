package com.test.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.app.domain.dto.MemberDto;
import com.test.app.domain.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/member")
public class MemberController {



	@Autowired
	private MemberService service;

	@GetMapping("/Register")
	public void get_memo() {
		log.info("GET /member/join");
	}

	@PostMapping("/Register")
	public String addMember(@ModelAttribute MemberDto dto)
	{
		log.info("POST /member/join" + dto);
		service.memberJoin(dto);

		return "member/auth/Login";
	}



}
