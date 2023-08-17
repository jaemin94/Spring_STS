package com.test.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfigure implements WebMvcConfigurer{

	// ���� ���ε� ����
	@Bean
	public MultipartResolver multipartResolver()
	{
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(20971520); 			// 20MB // ��ü ���ε� ��� ������ ������� 1024*1024*20 ���� ������ ��
		multipartResolver.setMaxUploadSizePerFile(20971520); 	// 20MB // ���� 1���� ��밡���� ���ε� ������
		multipartResolver.setMaxInMemorySize(20971520); 		// 20MB // ĳ�� ����
		return multipartResolver;
	}
	
	
	
	// �⺻��� ����
	 @Override 
	 public void addResourceHandlers(ResourceHandlerRegistry registry) 
	 {
	 registry.addResourceHandler("/resources/**").addResourceLocations(
	 "/resources/"); 
	 }
	 

	
}
