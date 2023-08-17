package com.test.app.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@MapperScan("com.test.app.domain.mapper")
@ComponentScans({
	@ComponentScan(basePackages ="com.test.app.config"),
	@ComponentScan(basePackages ="com.test.app.domain.service"),
	@ComponentScan(basePackages ="com.test.app.aop"),
	@ComponentScan(basePackages ="com.test.app.scheduled"),
	
})
public class RootConfig {

}
