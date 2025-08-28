package OOP.b_coffeemanager.OOP.domain.multilingual.payment.translate;

import OOP.b_coffeemanager.OOP.domain.payment.Payment;

public abstract class PaymentDecorator implements Translatable<Payment>{

	protected Translatable<Payment> target;

	public PaymentDecorator(Translatable<Payment> target) {
		this.target = target;
	}
	
}
