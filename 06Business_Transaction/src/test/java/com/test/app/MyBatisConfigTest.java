package com.test.app;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.app.domain.dto.MemoDto;
import com.test.app.domain.mapper.MemoMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyBatisConfigTest {

	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void test() {
		System.out.println("sqlSessionFactory : " + sqlSessionFactory);
		SqlSession session = sqlSessionFactory.openSession();
		System.out.println("session : " + session);
		Connection conn = session.getConnection();
		System.out.println("conn : " + conn);
	}
	
	@Autowired
	MemoMapper memoMapper;
	
	@Test
	public void test2()
	{
		System.out.println("memoMapper : " + memoMapper);
//		
		memoMapper.insert(new MemoDto(10,"hahaa"));
		memoMapper.insert(new MemoDto(11,"hahaaa"));
		memoMapper.insert(new MemoDto(12,"hahaaa"));


//		memoMapper.update(new MemoDto(10,"집보내줘"));
////		
//		memoMapper.delete(13);
		
//		MemoDto dto = memoMapper.selectAt(13);
//		System.out.println("selectAt dto : " + dto);
		
//		List<MemoDto> list = memoMapper.selectAll();
//		list.forEach((dto)->{System.out.println(dto);});
		
//		List<Map<String,Object>> list = memoMapper.selectAllResultMap();
//		list.forEach((map)->{
////			System.out.println(dto);
//			for(String key : map.keySet())
//			{
//				System.out.println(key + " : " + map.get(key));
//			}
//			});
//		
	}
	
	@Test
	public void test3()
	{
		System.out.println("memoMapper : " + memoMapper);
		MemoDto dto = new MemoDto(16,"aaabbbccc");
		
		int cnt = memoMapper.insert(dto);
		System.out.println("증가된 행수 : " + cnt);
		System.out.println("다음 ID 값 : " + dto.getId());
	}

}
