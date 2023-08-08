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
	// �޸��ۼ�		: insert
	public int addMemo(MemoDto dto)
	{
		log.info("MemberService's addMemo");
		return mapper.insert(dto);
		
	}
	
	// �޸��ۼ�		: insert
	@Transactional(rollbackFor = Exception.class)
	public void addMemoTx(MemoDto dto)
	{
		log.info("MemberService's addMemoTx");
		int id = dto.getId();
		mapper.insert(dto);	// 01 ���� Insert
		dto.setId(id);		// PK ���� �߻������� dto
		mapper.insert(dto);	// 02 PK���� �߻�
		
		
	}
	// ��ü�޸�������	: select *
	public List<MemoDto> getAllMemo()
	{
		log.info("MemberService's getAllMemo");
		List<MemoDto> list =mapper.selectAll();
		return list;
		
	}
	// �ܰǸ޸�������	: select * where
	// �޸����		: update
	// �޸����		: delete
}
