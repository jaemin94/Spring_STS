package com.test.app.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.test.app.domain.dto.ProdDto;

@Mapper
public interface ProdMapper {

	@Select("select *from tbl_product")
	public List<ProdDto> select();
	
	@Select("select * from tbl_product where product_code=#{product_code}")
	public ProdDto selectAt(int product_code);
	
	@Insert("insert into tbl_product values(#{product_code},#{product_name},#{amount},#{prod_price})")
	public int insert(ProdDto dto);
	
	@Update("update tbl_product set product_name = #{product_name}, amount = #amount}, prod_price=#{prod_price} where product_code = #{product_code}")
	public int update(ProdDto dto);
	
	@Delete("delete from tbl_product where product_code = #{product_code}")
	public int delete(int product_code);
	
}
