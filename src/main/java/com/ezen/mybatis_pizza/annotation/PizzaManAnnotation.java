package com.ezen.mybatis_pizza.annotation;

public class PizzaManAnnotation {

	public static void main(String[] args) {
		try {
			var main = new PizzaManAnnotation();
			/**
			 * 4번 메뉴의 가격을 갱신한다.
			 */
			main.updateMenuData(4, 3_0000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void updateMenuData(int menu_id, 
			int menu_price) throws Exception {
		
		var petDAOImpl = new PizzaMenuDAOimpl();
		int rowCnt = petDAOImpl.updateMenuData(
				menu_id, menu_price);
		
		System.out.println("갱신된 행 수: " + rowCnt);
	}
}
