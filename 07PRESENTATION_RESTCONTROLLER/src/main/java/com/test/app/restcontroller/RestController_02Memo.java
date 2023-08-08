package com.test.app.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.app.domain.dto.MemoDto;
import com.test.app.domain.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/memo")
public class RestController_02Memo {

	@Autowired
	private MemoService service;
	
	// �޸� Ȯ��
	@GetMapping(value="/getAll",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MemoDto> getAll()
	{
		log.info("GET/memo/getAll");
		return service.getAllMemo();
	}
	
	// �޸� Ȯ��(�ܰ�)
	@GetMapping("/get/{id}")
	public void get(@PathVariable int id)
	{
		log.info("GET/memo/get..." + id);
	}
	
	
	// �޸� ����
	@PostMapping("/add")
	public void add(@RequestBody MemoDto dto)
	{
		log.info("POST/memo/add..."+dto);
		service.addMemo(dto);
	}
	
	
	// �޸� ����
	// put	: ���ҽ� ��ü ����
	// patch: ���ҽ� �Ϻ� ����
	@PutMapping("/put/{id}/{text}")
	public void put(MemoDto dto)
	{
		log.info("POST/memo/put..." + dto);
	}
	
	@PutMapping("/put2")
	public void put2(@RequestBody MemoDto dto)
	{
		log.info("POST/memo/put2..." + dto);
		service.modifyMemo(dto);
	}
	
	@PatchMapping("/patch/{id}/{text}")
	public void patch(MemoDto dto)
	{
		log.info("patch/memo/patch..." + dto);
	}
	
	// �޸� ����
	@DeleteMapping("/remove/{id}")
	public void remove(@PathVariable int id)
	{
		log.info("Delete/memo/remove..." + id );
		service.removeMemo(id);
	}
}
