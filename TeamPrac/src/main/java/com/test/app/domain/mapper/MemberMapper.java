package com.test.app.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.test.app.domain.dto.MemberDto;

@Mapper
public interface MemberMapper{

	@Insert("insert into tbl_member values(#{member_id},#{pw},#{name},#{adr_addr},#{role})")
	public int insert(MemberDto dto);
	
//	@Select("select * from tbl_member")
//	public List<MemberDto> select();
	
	@Select("select * from tbl_member where member_id = #{member_id}")
	public MemberDto select(String member_id);
}
