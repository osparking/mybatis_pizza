package com.ezen.mybatis_pizza.procedure;

public class PizzaManProc {

	public static void main(String[] args) {
		var main = new PizzaManProc();
		main.callDelete_old_orders();
//		main.getPizzaMenu();
	}
	
	private void getPizzaMenu() {
		var menuDAOanno = new MenuDAOanno();
		
		try {
			var menu = menuDAOanno.getPizzaMenu();
			menu.stream().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void callDelete_old_orders() {
		var orderDvo = new OrderDVO();
		int order_id = 4;
		
		orderDvo.setOrder_id(order_id);
		
		OrderDAO orderDao = new OrderDAOanno();
		try {
			orderDao.callDelete_old_orders(order_id);
			System.out.println("삭제된 최대 주문 번호: " + order_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
