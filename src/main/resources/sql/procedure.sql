CREATE PROCEDURE pizza_bro.delete_old_orders(
  IN in_order_id INT)
begin
	delete from order_item where order_id <= in_order_id;
	delete from pizza_order where order_id <= in_order_id;
END

CREATE PROCEDURE pizza_bro.getPizzaMenu()
begin
	select * from pizza_menu pm;
END;
