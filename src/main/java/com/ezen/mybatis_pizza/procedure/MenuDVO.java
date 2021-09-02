package com.ezen.mybatis_pizza.procedure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class MenuDVO { 
	private int menu_id;
	private String menu_name;
	private int menu_price;
}
