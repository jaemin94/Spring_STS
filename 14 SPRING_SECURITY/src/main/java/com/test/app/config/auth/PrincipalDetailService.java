package com.test.app.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.app.domain.dto.UserDto;
import com.test.app.domain.mapper.UserMapper;

@Service
public class PrincipalDetailService implements UserDetailsService {

	@Autowired
	private UserMapper mapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDto dto = mapper.selectAt(username);
		
		if (dto == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
		return new PrincipalDetails(dto);
	}

}
