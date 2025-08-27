package OOP.b_coffeemanager.OOP.domain.discount.policy;

import OOP.b_coffeemanager.OOP.domain.order.Order;

public abstract class DiscountPolicy {

	public int calculatePaymentPrice(Order order) {
		return order.getOrderPrice() - getDiscountAmount(order);
	}

	protected abstract int getDiscountAmount(Order order);
}
