package com.ezen.mybatis_pizza.procedure;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MenuDAOanno implements MenuDAO {

	@Override
	public List<MenuDVO> getPizzaMenu() throws Exception {
		SqlSession sqlSession = getSqlSession();
		var mapper = sqlSession.getMapper(MenuMapper.class);
		return mapper.getPizzaMenu();
	}
	
	private static SqlSession getSqlSession() throws Exception {
		String resource = "procedure/java-mybatis-config.xml";
		InputStream inputStream = 
				Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory 
			= new SqlSessionFactoryBuilder().build(inputStream);
		sqlSessionFactory.getConfiguration()
			.addMapper(MenuMapper.class);
		return sqlSessionFactory.openSession();
	}
}
