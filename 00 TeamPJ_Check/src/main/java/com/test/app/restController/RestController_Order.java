package com.test.app.restController;

import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.app.domain.dto.OrderDto;
import com.test.app.domain.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/order")
public class RestController_Order {

	@Autowired
	OrderService service;
	
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
	
	
	@PutMapping("/Order_Update")
    public ResponseEntity<String> updateOrders(@RequestBody List<OrderDto> orderUpdateRequestDTOList) {
        try {
            // DTO 리스트를 사용하여 주문 정보 업데이트 작업 수행
            for (OrderDto dto : orderUpdateRequestDTOList) {
                // dto를 사용하여 비즈니스 로직 처리
                service.updateOrder(dto);
            }
            return ResponseEntity.ok("Order(s) updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to update order(s): " + e.getMessage());
        }
    }
	
	@DeleteMapping(value ="/Order_delete" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteOrder(@RequestParam(required = false) String order_id)
	{ 
		try {
       
		String decodedOrderId = URLDecoder.decode(order_id, "UTF-8");
                log.info("Deleting order: " + order_id);
                service.removeOrder(decodedOrderId);
       
            return ResponseEntity.ok("Order(s) deleted successfully.");
        
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Failed to delete order(s): " + e.getMessage());
    }
	}
}
