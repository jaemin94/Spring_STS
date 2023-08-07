package com.test.app.controller;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.app.domain.dto.MemberDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/member")
public class MemberController {
	
	@InitBinder
	public void dataBinder(WebDataBinder dataBinder) {
		System.out.println("MemeberController's dataBinder.. " + dataBinder);
		// String 형태인 날짜를 LocalDate으로 변환 시키는 Editor
		dataBinder.registerCustomEditor(LocalDate.class, "birthday", new MemberDtoEditor());
		
		// String[]의 구분자를 추가하는 작업
		dataBinder.registerCustomEditor(String[].class,new StringArrayPropertyEditor("#"));
		dataBinder.registerCustomEditor(String[].class,new StringArrayPropertyEditor(" "));
	
	}
	
	
	
	@GetMapping("/join")
	public void get_memo() {
		log.info("GET /member/join");
	}
	
	@PostMapping("/join")
	public String post_memo(@Valid @ModelAttribute MemberDto dto,BindingResult bindingResult, Model model) {
		log.info("POST /member/join" + dto);
		if(bindingResult.hasFieldErrors()) {
			
			for (FieldError error : bindingResult.getFieldErrors()) {
                System.out.println(error.getField() + ": " + error.getDefaultMessage());
                model.addAttribute(error.getField(),error.getDefaultMessage());
            }
			return "member/join";
		}
		
		return "";
	}

}

class MemberDtoEditor extends PropertyEditorSupport{

	// String 을 우리가 원하는 Object로 변환 시켜주는 함수
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		System.out.println("MemberDtoEditor's setAsText : " + text);
		setValue(LocalDate.parse(text,DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		
	}
	
	
}