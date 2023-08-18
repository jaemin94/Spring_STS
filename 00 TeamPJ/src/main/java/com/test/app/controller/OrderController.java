package com.test.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.app.domain.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService service;
	
	@GetMapping("/ShoppingBasket_Admin")
	public void getOrder(String order_id)
	{
		log.info("OrderController's getOrder");
		if(order_id != null)
		{
			service.getOrder(order_id);
		}
		else
		{
			service.getAllOrder();
		}
	}
	
	@GetMapping("/ShoppingBasket_user")
	public void getOrderMember(String username)
	{
		log.info("OrderController's getOrderMember");
			service.getAllOrderMember(username);
	
	}
}
