package com.test.app.config.auth;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		System.out.println("CustomLoginSuccessHandler's onAuthenticationSuccess");
		Collection<? extends GrantedAuthority> collection = authentication.getAuthorities();
		collection.forEach((role)->{
			
			System.out.println(role);
			String role_str=role.getAuthority();
			request.getSession().setAttribute("role",role_str);
			System.out.println("CustomLoginSuccessHandler : " + role_str);
			log.info("CustomLoginSuccessHandler Role : " , role_str);
			try {
//			if(role_str.equals("ROLE_User"))
//			{
//				System.out.println("USER 페이지로 이동!");
//				
//					response.sendRedirect(request.getContextPath()+"/user");
//			}else if(role_str.equals("ROLE_Member"))
//			{
//				System.out.println("Member 페이지로 이동!");
//				response.sendRedirect(request.getContextPath()+"/member");
//			}else if(role_str.equals("ROLE_Admin"))
//			{
//				System.out.println("Admin 페이지로 이동!");
//				response.sendRedirect(request.getContextPath()+"/adming");
//			}
			
				response.sendRedirect(request.getContextPath() + "/Main");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

}
