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
public class MemberService implements UserDetailsService{

	@Autowired
	MemberMapper mapper;
	

	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	public int memberJoin(MemberDto dto)
	{
		String encryptedPassword = passwordEncoder.encode(dto.getPw());
        dto.setPw(encryptedPassword);
		log.info("MemberService's memberJoin");
		return mapper.insert(dto);
	}

	@Override
	public UserDetails loadUserByUsername(String member_id) throws UsernameNotFoundException {
		
		MemberDto memberDto = mapper.select(member_id);
//		System.out.println("MemberService's loadUserByUsername : " + memberDto);
		
		if (memberDto == null) {
            throw new UsernameNotFoundException("User not found with username: " + member_id);
        }

		 List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(memberDto.getRole()));
		
        // UserDetails 객체를 생성하여 반환
		UserDetails userDetails = new User(memberDto.getUsername(), memberDto.getPassword(), authorities);
//        System.out.println("UserDetails: {}" + userDetails); // 로그로 UserDetails 확인
        return userDetails;
		
		
	}
	
}
