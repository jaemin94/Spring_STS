package com.test.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.app.domain.dto.MemberDto;
import com.test.app.domain.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
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
	
	
	
	
	
	@GetMapping("/auth/Login")
	public void login(MemberDto dto)
	{
		log.info("GET/memmber/login" + dto);
		
		
	}
	
	 @PostMapping("/auth/login")
	    public String processLogin(@RequestParam String member_id, @RequestParam String pw, Model model) {
	        
		 	
		 try {
 
	        	 // 사용자 인증을 위한 토큰 생성
	            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(member_id, pw);
	            System.out.println("a : " +token);
	            // AuthenticationManager를 사용하여 사용자 인증 처리
	            Authentication authentication = authenticationManager.authenticate(token);
	            System.out.println("b : " +authentication);
	            // 인증 정보를 SecurityContextHolder에 저장
	            SecurityContextHolder.getContext().setAuthentication(authentication);

	         // UserDetails 가져오기
	            UserDetails userDetails = service.loadUserByUsername(member_id);
	           System.out.println("뭐가 나오냐 : " + userDetails.getAuthorities());
	         
//	            System.out.println("출력좀해라!" + userDetails);
//	           
	            
	            // 세션에 UserDetails 저장 (사용자 정보 유지)
	            model.addAttribute("userDetails", userDetails);
	            
	            return "/Main"; // 로그인 성공 시 리다이렉트 페이지
	        } catch (Exception e) {
	            // 로그인 실패 시 처리
	            model.addAttribute("error", true);
//	            System.out.println("에러떳다 수정해라");
	            System.out.println("로그인 실패: " + e.getMessage());
	            return "member/auth/Login"; // 로그인 페이지로 돌아가고 에러 메시지를 표시
	        }
	 }
	
}
