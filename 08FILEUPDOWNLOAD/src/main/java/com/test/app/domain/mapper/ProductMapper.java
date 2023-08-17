package com.test.app.domain.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {
	
	@Insert("insert into tbl_product values(#{productCode},#{path},#{productName},#{productType})")
	public int addProduct( 
			//service에서 받은 4개의 인자 각각 SQL문에 매핑
			@Param("productCode") int productCode,
			@Param("path") String path,
			@Param("productName") String productName,
			@Param("productType") String productType
			);
}
