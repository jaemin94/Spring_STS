package com.test.app.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.test.app.domain.dto.OrderDto;

@Mapper
public interface OrderMapper {

	@Select("select * from tbl_order")
	public List<OrderDto> selectAll();

	@Select("select * from tbl_order where member_id = #{member_id}")
	public List<OrderDto> selectAM(String member_id);
	
	@Select("select * from tbl_order where order_id = #{order_id}")
	public OrderDto selectAt(String order_id);
	
	@Insert("insert into tbl_order values(#{order_id},#{member_id},#{product_code},#{product_name},#{adr_addr},#{odr_amount},curdate(),#{price})")
	public int insert(OrderDto dto);
	
	@Update("update tbl_order set member_id=#{member_id}, odr_amount=#{odr_amount}, price=#{price} where order_id = #{order_id}")
	public int update(OrderDto dto);
	
	@Delete("delete from tbl_order where order_id = #{order_id}")
	public int delete(String order_id);
	
}
