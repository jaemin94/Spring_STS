package com.test.app.domain.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

	private String order_id;
	private String member_id;
	private int product_code;
	private String product_name;
	private String adr_addr;
	private int odr_amount;
	private Date odr_date;
	private int price;
	
}
