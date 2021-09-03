package com.ezen.mybatis_pizza.procedure;

import org.apache.ibatis.annotations.Delete;

public interface OrderMapper {
//	@Delete("{CALL delete_old_orders(#{ order_id, mode = IN, jdbcType = INTEGER})} ")
//	@Options(statementType = StatementType.CALLABLE)
	@Delete("delete from pizza_order where order_id <= #{order_id}")
	public void callDelete_old_orders(int order_id);
}
