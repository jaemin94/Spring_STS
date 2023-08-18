package com.test.app.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.domain.dto.OrderDto;
import com.test.app.domain.mapper.OrderMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {

	@Autowired
	OrderMapper mapper;
	
	public List<OrderDto> getAllOrder()
	{
		log.info("OrderService's getAllOrder");
		return mapper.selectAll();
	}
	
	public List<OrderDto> getAllOrderMember(String username)
	{
		log.info("OrderService's getAllOrderMember");
		return mapper.selectAM(username);
	}
	
	
	public OrderDto getOrder(String order_id)
	{
		log.info("OrderService's getOrder");
		return mapper.selectAt(order_id);
	}
	
	public int updateOrder(OrderDto dto)
	{
		log.info("OrderService's updateOrder");
		return mapper.update(dto);
	}
	
	public int removeOrder(String order_id)
	{
		log.info("OrderService's removeOrder");
		return mapper.delete(order_id);
	}
	
}
