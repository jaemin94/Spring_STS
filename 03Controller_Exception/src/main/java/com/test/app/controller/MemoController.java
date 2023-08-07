package com.test.app.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.io.FileNotFoundException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.app.domain.dto.MemoDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/memo")
public class MemoController {

	@GetMapping("/form")
	public void get() {
		log.info("GET/memo/form..");
	}

	@PostMapping("/post")
	public String post(@Valid MemoDto dto, BindingResult bindingResult, Model model) {

		log.info("POST / memo / post...." + dto);
		log.info("POST / memo / post.... isError" + bindingResult.getFieldErrors("id"));
		if (bindingResult.hasFieldErrors()) {

//			log.info("POST / memo / post... is Error " + bindingResult.getFieldError("id").getDefaultMessage());

			for(FieldError error :bindingResult.getFieldErrors())
			{
				log.info(error.getField() + " : " + error.getDefaultMessage());
				model.addAttribute(error.getField(), error.getDefaultMessage());
				
			}
			return "memo/form";
		}
		return null;
	}
	
//	@ExceptionHandler(FileNotFoundException.class)
//	public String error1(Exception ex, Model model)
//	{
//		System.out.println("FileNotFoundException.. ex : " +  ex);
//		System.out.println("FileNotFoundException.. ex : " +  ex);
//		model.addAttribute("ex",ex);
//		
//		return "memo/error";
//	}
//	
//	@ExceptionHandler(ArithmeticException.class)
//	public String error2(Exception ex, Model model)
//	{
//		System.out.println("FileNotFoundException.. ex : " +  ex);
//		System.out.println("FileNotFoundException.. ex : " +  ex);
//		model.addAttribute("ex",ex);
//		
//		return "memo/error2";
//	}
//	
//	@ExceptionHandler(Exception.class)
//	public String error4(Exception ex, Model model)
//	{
//		System.out.println("FileNotFoundException.. ex : " +  ex);
//		System.out.println("FileNotFoundException.. ex : " +  ex);
//		model.addAttribute("ex",ex);
//		
//		return "memo/error2";
//	}
	
	@GetMapping("/list1")
	public void list1() throws Exception
	{
		System.out.println("GET/memo/list1");
		throw new FileNotFoundException("파일 증발햇다..");
	}
	
	@GetMapping("/list2")
	public void list2()
	{
		System.out.println("GET/memo/list2");
		throw new ArithmeticException("계산 실패!!");
	}
	
	@GetMapping("/list3/{n1}/{n2}")
	public void list3(@PathVariable int n1, @PathVariable int n2)
	{
		System.out.println("GET/memo/list3");
		System.out.println("계산결과 : " +(n1/n2));
	}
	
	@GetMapping("/list4")
	public void list4()
	{
		System.out.println("GET/memo/list4");
		throw new NullPointerException();
		
	}

}
