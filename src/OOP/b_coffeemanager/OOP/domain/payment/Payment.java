package OOP.b_coffeemanager.OOP.domain.payment;

import OOP.b_coffeemanager.OOP.domain.account.Account;
import OOP.b_coffeemanager.OOP.domain.order.Order;

public class Payment {

	private Order order;
	private int paymentPrice;
	
	public Payment(Order order) {
		this.order = order;
		this.paymentPrice = order.getOrderPrice();
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
