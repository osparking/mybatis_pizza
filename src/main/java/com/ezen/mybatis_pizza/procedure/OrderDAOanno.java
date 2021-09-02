package com.ezen.mybatis_pizza.procedure;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class OrderDAOanno implements OrderDAO {

	@Override
	public void callDelete_old_orders(int order_id) throws Exception {
		SqlSession sqlSession = getSqlSession();
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

		mapper.callDelete_old_orders(order_id);
	}

	private static SqlSession getSqlSession() throws Exception {
		String resource = "procedure/java-mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		sqlSessionFactory.getConfiguration().addMapper(OrderMapper.class);

		return sqlSessionFactory.openSession();
	}
}
