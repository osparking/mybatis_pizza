package com.ezen.mybatis_pizza.procedure;

import com.ezen.mybatis_pizza.core.PizzaOrderDVO;

public class PizzaManProc {

	public static void main(String[] args) {
		var main = new PizzaManProc();
		main.callDelete_old_orders();
	}
	
	private void callDelete_old_orders() {
		PizzaOrderDVO orderDvo = new PizzaOrderDVO();
		int order_id = 11;
		
		orderDvo.setOrder_id(order_id);
		
		OrderDAO orderDao = new OrderDAOanno();
		try {
			orderDao.callDelete_old_orders(orderDvo);
			System.out.println("삭제된 최대 주문 번호: " + order_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
