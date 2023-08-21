package com.test.app.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.domain.dto.ProdDto;
import com.test.app.domain.mapper.ProdMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProdService {

	@Autowired
	ProdMapper mapper;
	
	public List<ProdDto> reqAllProd()
	{
		log.info("ProdService's reqAllProd");
		return mapper.select();
	}
	
	public ProdDto reqProd(int product_code)
	{
		log.info("ProdService's reqProd");
		return mapper.selectAt(product_code);
	}
	
	public int addProd(ProdDto dto)
	{
		log.info("ProdService's addProd");
		return mapper.insert(dto);
	}
	
	public int updateProd(ProdDto dto)
	{
		log.info("ProdService's updateProd");
		return mapper.update(dto);
	}
	
	// 상품 주문시 재고 자동 업데이트
	public int updateProdAmount(ProdDto dto)
	{
		log.info("ProdService's updateProdAmount");
		return mapper.update(dto);
	}
	
	public int removeProd(int product_code)
	{
		log.info("ProdService's removeProd");
		return mapper.delete(product_code);
	}
	
}
