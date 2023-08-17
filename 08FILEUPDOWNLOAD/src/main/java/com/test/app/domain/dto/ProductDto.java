package com.test.app.domain.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
	private int productCode;		//��ǰ�ڵ�
	private MultipartFile[] files;	//�̹��� ���ϵ�
	private String productName;		//��ǰ �̸�
	private String productType;		//��ǰ ����
}
