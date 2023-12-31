package com.test.app.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class RootConfig {

//	// Spring JDBC 가 제공해주는 DataSource
//	@Bean
//	public DataSource dataSource()
//	{
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/bookdb");
//		dataSource.setUsername("root");
//		dataSource.setPassword("1234");
//		return dataSource;
//	}
	
	// HikariCp DataSource
	@Bean
	public HikariDataSource dataSource2()
	{
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/bookdb");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		
		return dataSource;
	}
	
}
