package com.ezen.mybatis_pizza.procedure;

import java.util.List;

public interface MenuDAO {
	List<MenuDVO> getPizzaMenu() throws Exception ;
}
