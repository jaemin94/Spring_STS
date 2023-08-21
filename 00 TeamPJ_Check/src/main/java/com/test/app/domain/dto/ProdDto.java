package com.test.app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdDto {

	private int product_code;
	private String product_name;
	private int amount;
	private int prod_price;
	
}
