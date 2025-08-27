package OOP.b_coffeemanager.OOP.domain.sale;

import OOP.b_coffeemanager.OOP.domain.discount.policy.AmountDiscountPolicy;
import OOP.b_coffeemanager.OOP.domain.discount.policy.PercentDiscountPolicy;
import OOP.b_coffeemanager.OOP.domain.order.Order;
import OOP.b_coffeemanager.OOP.domain.payment.Payment;

public class SaleContext {

	public Payment init(Order order) {
		order.proceed();
		Payment payment = new Payment(order, new AmountDiscountPolicy(500));
		payment.proceed();
		return payment;
	}

}
