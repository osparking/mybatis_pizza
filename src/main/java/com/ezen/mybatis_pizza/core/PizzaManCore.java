package com.ezen.mybatis_pizza.core;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class PizzaManCore {

	public static void main(String[] args) {
		/**
		 * 고객이름, 메뉴이름 입력 받아 주문 및 주문 아이템 저장
		 */
		String cust_name = "장민석";
		String menu_name = "마카리타";

		PizzaManCore main = new PizzaManCore();
		main.createPizzaOrder(cust_name, menu_name);
	}

	private int createPizzaOrder(String cust_name, String menu_name) {
		Map<String, Object> orderMap = new HashMap<>();

		orderMap.put("cust_name", cust_name);

		SqlSession sqlSession;
		try {
			sqlSession = getSqlSession();
			sqlSession.insert("createPizzaOrder", orderMap);
			Long newID = (Long) orderMap.get("order_id");
			
			System.out.println("삽입된 주문 ID: " + newID);
//			sqlSession.insert("createOrderItem", orderMap);
			sqlSession.commit();
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	//@formatter:off
	private static SqlSession getSqlSession() throws Exception {
		String resource = "core-mybatis-config.xml";
		InputStream inputStream = 
				Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory.openSession();
	}
}
