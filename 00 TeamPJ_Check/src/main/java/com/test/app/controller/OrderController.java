package com.test.app.controller;

import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.app.domain.dto.OrderDto;
import com.test.app.domain.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService service;
	
	@GetMapping("/ShoppingBasket_Admin")
	public String getOrder()
	{
		log.info("OrderController's getOrder");
		return "/order/ShoppingBasket_Admin";
	}	
	
	@GetMapping("/ShoppingBasket_user")
	public String getOrderMember()
	{
		log.info("OrderController's getOrderMember");
		return "/order/ShoppingBasket_user";
			
	}
	
	

}
