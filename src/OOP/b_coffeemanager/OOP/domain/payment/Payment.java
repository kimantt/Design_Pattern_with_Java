package OOP.b_coffeemanager.OOP.domain.payment;

import OOP.b_coffeemanager.OOP.domain.account.Account;
import OOP.b_coffeemanager.OOP.domain.discount.policy.DiscountPolicy;
import OOP.b_coffeemanager.OOP.domain.order.Order;

public class Payment {

	private Order order;
	private int paymentPrice;
	private DiscountPolicy discountPolicy;
	
	public Payment(Order order, DiscountPolicy discountPolicy) {
		this.order = order;
		this.discountPolicy = discountPolicy;
		this.paymentPrice = discountPolicy.calculatePaymentPrice(order);
	}
	
	public Order getOrder() {
		return order;
	}
	public int getPaymentPrice() {
		return paymentPrice;
	}
	
	public void proceed() {
		Account account = Account.getInstance();
		account.registSales(paymentPrice);
	}
}
