package com.ezen.mybatis_pizza.procedure;

import com.ezen.mybatis_pizza.core.PizzaOrderDVO;

public interface OrderDAO {
	void callDelete_old_orders(PizzaOrderDVO petDVO) 
			throws Exception;
}
