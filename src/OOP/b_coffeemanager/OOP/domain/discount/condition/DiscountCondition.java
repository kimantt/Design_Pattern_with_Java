package OOP.b_coffeemanager.OOP.domain.discount.condition;

import OOP.b_coffeemanager.OOP.domain.order.Order;

public interface DiscountCondition {

	boolean isSatisfied(Order order);
	
}
