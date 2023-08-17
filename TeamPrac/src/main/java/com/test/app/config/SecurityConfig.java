package com.test.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.test.app.config.auth.CustomAuthenticationFailureHandler;
import com.test.app.config.auth.CustomLoginSuccessHandler;
import com.test.app.domain.service.MemberService;

// security-context.xml 설정 내용

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	

	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MemberService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();	// 중간 공격을 맞아주는 설정
		
		http
			.authorizeRequests()							// 인하 처리 
				.antMatchers("/","/public","/Main").permitAll()
				// hasRole을 사용시 기본적으로 Role_ 이 제공된다
				.antMatchers("/user").hasRole("User")		// Role_User	
				.antMatchers("/member","/order").hasRole("Member")	// Role_Member
				.antMatchers("/admin","/order").hasRole("Admin")		// Role_Admin
				.anyRequest().authenticated()				// 나머지 URL은 모두 인증작업이 완료된 이후 접근가능
				.and()
				.formLogin()								// 로그인이 되지 않은 상태에서 자동으로 로그인 페이지로 리다이렉팅이 된다
				.loginPage("/member/auth/Login")
				.successHandler(new CustomLoginSuccessHandler())
				.failureHandler(new CustomAuthenticationFailureHandler())
				
				.and()
				.logout();
		
		
		
	}

	// 인증처리 함수
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// auth.userDetailsService : DB 연결할때 사용되는 함수
		auth.userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder);

		
	}
	
	
	
	// BCryptPasswordEncoder	: 비밀번호를 암호화 시키는 작업

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
	
	}
	
}
