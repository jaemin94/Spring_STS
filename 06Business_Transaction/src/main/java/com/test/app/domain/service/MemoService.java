package com.test.app.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.app.domain.dto.MemoDto;
import com.test.app.domain.mapper.MemoMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemoService {

	@Autowired
	private MemoMapper mapper;
	
	// CRUD
	// 메모작성		: insert
	public int addMemo(MemoDto dto)
	{
		log.info("MemberService's addMemo");
		return mapper.insert(dto);
		
	}
	
	// 메모작성		: insert
	@Transactional(rollbackFor = Exception.class)
	public void addMemoTx(MemoDto dto)
	{
		log.info("MemberService's addMemoTx");
		int id = dto.getId();
		mapper.insert(dto);	// 01 정상 Insert
		dto.setId(id);		// PK 오류 발생예정인 dto
		mapper.insert(dto);	// 02 PK오류 발생
		
		
	}
	// 전체메모가져오기	: select *
	public List<MemoDto> getAllMemo()
	{
		log.info("MemberService's getAllMemo");
		List<MemoDto> list =mapper.selectAll();
		return list;
		
	}
	// 단건메모가져오기	: select * where
	// 메모수정		: update
	// 메모삭제		: delete
}
