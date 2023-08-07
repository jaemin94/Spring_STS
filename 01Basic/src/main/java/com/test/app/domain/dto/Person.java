package com.test.app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	private String name = "홍길동";
	private int age = 55;
	private String addr = "대구";	
}
