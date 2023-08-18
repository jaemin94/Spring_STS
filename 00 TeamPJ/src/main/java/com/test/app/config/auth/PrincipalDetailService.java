package com.test.app.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.app.domain.dto.MemberDto;
import com.test.app.domain.mapper.MemberMapper;

@Service
public class PrincipalDetailService implements UserDetailsService {

	@Autowired
	private MemberMapper mapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MemberDto dto = mapper.select(username);
		
		if (dto == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
		return new PrincipalDetails(dto);
	}

}
