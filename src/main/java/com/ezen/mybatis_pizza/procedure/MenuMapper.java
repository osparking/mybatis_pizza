package com.ezen.mybatis_pizza.procedure;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;


public interface MenuMapper {
	@Select(value="{CALL getPizzaMenu()}")
	@Options(statementType = StatementType.CALLABLE)
	public List<MenuDVO> getPizzaMenu();
}
