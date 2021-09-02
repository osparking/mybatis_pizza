package com.ezen.mybatis_pizza.procedure;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.mapping.StatementType;

import com.ezen.mybatis_pizza.core.PizzaOrderDVO;

public interface OrderMapper {
	@Delete("{CALL delete_old_orders(#{ order_id, mode = IN, jdbcType = INTEGER})} ")
	@Options(statementType = StatementType.CALLABLE)
	public void callDelete_old_orders(int order_id);
}
