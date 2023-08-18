package com.test.app.domain.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.app.domain.dto.MemberDto;
import com.test.app.domain.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService {

	@Autowired
	MemberMapper mapper;

	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

	public List<MemberDto> searchAllMember()
	{
		log.info("MemberService's memberJoin");
		return mapper.selectAll();
	}
	
	public MemberDto searchOne(String username)
	{
		return mapper.select(username);
	}
	
	public int memberJoin(MemberDto dto)
	{
		String encryptedPassword = passwordEncoder.encode(dto.getPassword());
        dto.setPassword(encryptedPassword);
		log.info("MemberService's memberJoin");
		return mapper.insert(dto);
	}

	public int memberUpdate(MemberDto dto)
	{
		String encryptedPassword = passwordEncoder.encode(dto.getPassword());
        dto.setPassword(encryptedPassword);
		log.info("MemberService's memberUpdate");
		return mapper.update(dto);
	}
	
	public int memberDelete(String username)
	{
		log.info("MemberService's memberDelete");
		return mapper.delete(username);
	}

}
