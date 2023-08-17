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

	// 파일 업로드 설정
	@Bean
	public MultipartResolver multipartResolver()
	{
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(20971520); 			// 20MB // 전체 업로드 허용 사이즈 사이즈는 1024*1024*20 으로 설정된 값
		multipartResolver.setMaxUploadSizePerFile(20971520); 	// 20MB // 파일 1개당 허용가능한 업로드 사이즈
		multipartResolver.setMaxInMemorySize(20971520); 		// 20MB // 캐시 공간
		return multipartResolver;
	}
	
	
	
	// 기본경로 설정
	 @Override 
	 public void addResourceHandlers(ResourceHandlerRegistry registry) 
	 {
	 registry.addResourceHandler("/resources/**").addResourceLocations(
	 "/resources/"); 
	 }
	 

	
}
