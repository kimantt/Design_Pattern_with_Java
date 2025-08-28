package OOP.b_coffeemanager.OOP.domain.multilingual.payment.translate;

import OOP.b_coffeemanager.OOP.domain.payment.Payment;

public class UsaDecorator extends PaymentDecorator {

	public UsaDecorator(Translatable<Payment> target) {
		super(target);
	}

	@Override
	public String tranlate() {
		String info = target.tranlate();
		Payment payment = origin();
		
		int price = Math.max(payment.getPaymentPrice()/1300, 1);
		
		info += "\n" + payment.getOrder().getName() + "cup"
				+ "\n" + price + "dollar";
		return info;
	}

	@Override
	public Payment origin() {
		return target.origin();
	}

}
