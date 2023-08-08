package com.test.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zaxxer.hikari.HikariDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTest {

	@Autowired
	private DataSource ds;
	
	@Autowired
	private HikariDataSource dataSource2;
	
	@Test
	public void test() throws SQLException {
		Connection conn = ds.getConnection();
		System.out.println(conn);
		PreparedStatement pstmt = conn.prepareStatement("insert into tbl_book values(2021,'집이좋다','집','갈래')");
		pstmt.executeUpdate();
	}
	
	@Test
	public void test2() throws SQLException {
		Connection conn = dataSource2.getConnection();
		System.out.println(conn);
		PreparedStatement pstmt = conn.prepareStatement("insert into tbl_book values(2031,'집이좋다','집','갈래')");
		pstmt.executeUpdate();
	}

}
