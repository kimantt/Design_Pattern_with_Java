package OOP.b_coffeemanager.OOP.domain.discount.policy;

import OOP.b_coffeemanager.OOP.domain.discount.condition.DiscountConditionType;
import OOP.b_coffeemanager.OOP.domain.order.Order;

public class PercentDiscountPolicy extends DiscountPolicy {

	private double percent;
	
	public PercentDiscountPolicy(double percent) {
		if (percent < 0 || percent > 1) {
			throw new IllegalArgumentException("할인률은 0보다 크고 1보다 작아야합니다.");
		}
		this.percent = percent;
	}
	
	@Override
	protected int getDiscountAmount(Order order) {
		for (DiscountConditionType conditionType : DiscountConditionType.values()) {
			if (conditionType.condition().isSatisfied(order)) {
				double discountAmount = order.getOrderPrice() * percent;
				return (int)discountAmount;
			}
		}
		return 0;
	}

}
