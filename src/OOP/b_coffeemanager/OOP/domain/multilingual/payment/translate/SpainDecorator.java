package OOP.b_coffeemanager.OOP.domain.multilingual.payment.translate;

import OOP.b_coffeemanager.OOP.domain.payment.Payment;

public class SpainDecorator extends PaymentDecorator {

	public SpainDecorator(Translatable<Payment> target) {
		super(target);
	}

	@Override
	public String tranlate() {
		String info = target.tranlate();
		Payment payment = origin();
		
		int price = Math.max(payment.getPaymentPrice()/1400, 1);
		
		info += "\n" + payment.getOrder().getName() + "tazas de"
				+ "\n" + price + "eur";
		return info;
	}

	@Override
	public Payment origin() {
		return target.origin();
	}

}
