package com.test.app.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.app.domain.dto.UserDto;
import com.test.app.domain.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService{


	@Autowired
	private UserMapper mapper;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	public int userJoin(UserDto dto)
	{
		String encryptedPassword = passwordEncoder.encode(dto.getPw());
        dto.setPw(encryptedPassword);
        dto.setRole("Role_User");
		log.info("UserService's userJoin");
		return mapper.insert(dto);
	}


}
