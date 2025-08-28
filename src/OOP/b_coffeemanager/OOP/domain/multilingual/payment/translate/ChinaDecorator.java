package OOP.b_coffeemanager.OOP.domain.multilingual.payment.translate;

import OOP.b_coffeemanager.OOP.domain.payment.Payment;

public class ChinaDecorator extends PaymentDecorator {

	public ChinaDecorator(Translatable<Payment> target) {
		super(target);
	}

	@Override
	public String tranlate() {
		String info = target.tranlate();
		Payment payment = origin();
		info += "\n" + payment.getOrder().getName() + "杯"
				+ "\n" + payment.getPaymentPrice()/200 + "wian";
		return info;
	}

	@Override
	public Payment origin() {
		return target.origin();
	}

}
