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

ALTER TABLE pizza_bro.order_item DROP FOREIGN KEY fk_order_id;
ALTER TABLE pizza_bro.order_item 
	ADD CONSTRAINT fk_order_id FOREIGN KEY (order_id) 
		REFERENCES pizza_bro.pizza_order(order_id) 
	ON DELETE CASCADE ON UPDATE RESTRICT;
	
DROP PROCEDURE IF EXISTS pizza_bro.delete_old_orders;

DELIMITER $$
$$
CREATE PROCEDURE pizza_bro.delete_old_orders(
	IN in_order_id INT)
begin
	delete from pizza_order where order_id <= in_order_id;
end;
$$
DELIMITER ;
	