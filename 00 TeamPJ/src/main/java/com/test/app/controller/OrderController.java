package com.test.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping(value = "/ShoppingBasket_Admin2" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String getOrderToUpdateDelete()
	{
		log.info("OrderController's getOrder");
		return "/order/ShoppingBasket_Admin2";
	}
	
	@GetMapping(value = "/AdminOrder", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getOrderAdmin(@RequestParam(required = false) String order_id)
	{
		 log.info("OrderController's getOrderAdmin");
		 if (order_id != null && !order_id.isEmpty()) {
		        OrderDto order = service.getOrder(order_id);
		        if (order != null) {
		            return ResponseEntity.ok(order);
		        } else {
		            return ResponseEntity.notFound().build();
		        }
		    } else {
		        List<OrderDto> orderList = service.getAllOrder();
		        return ResponseEntity.ok(orderList);
		    }
		 
	}
	
	@GetMapping("/ShoppingBasket_user")
	public String getOrderMember()
	{
		log.info("OrderController's getOrderMember");
		return "/order/ShoppingBasket_user";
			
	}
	
	@GetMapping(value = "/MemberOrder", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getOrderMember(@RequestParam(required = false) String username ,@RequestParam(required = false) String order_id) {
	    log.info("OrderController's getOrderMember");
	    log.info("username : " , username);
	    
	    if (order_id != null && !order_id.isEmpty()) {
	        OrderDto order = service.getOrder(order_id);
	        if (order != null) {
	            return ResponseEntity.ok(order);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    } else {
	        List<OrderDto> orderList = service.getAllOrderMember(username);
	        return ResponseEntity.ok(orderList);
	    }
	}

}
