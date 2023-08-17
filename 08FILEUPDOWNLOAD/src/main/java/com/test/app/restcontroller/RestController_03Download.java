package com.test.app.restcontroller;

import java.io.UnsupportedEncodingException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class RestController_03Download {

	@GetMapping(value="/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> Download(String path) throws UnsupportedEncodingException
	{
		
		log.info("REST CONTROLLER DOWNLOAD !!  " + path);
		
		// FileSystemResource : ���Ͻý����� Ư�� ���Ϸκ��� ������ �������µ� ���
		Resource resource = new FileSystemResource(path);
		
		// ���ϸ� ����
		String filename = resource.getFilename();
		
		// ��� ���� �߰�
		HttpHeaders headers = new HttpHeaders();
		// ISO-8859-1 : ��ƾ��(Ư�����ڵ� ���� ����)
		headers.add("Content-Disposition", "attachment; filename=" + new String (filename.getBytes("UTF-8"),"ISO-8859-1"));
		// ���ҽ�, ���������� ���Ե� ���, ���������� ����
		return new ResponseEntity<Resource>(resource,headers,HttpStatus.OK);
	}
	
}
