package OOP.b_coffeemanager.OOP.domain.order;

import OOP.b_coffeemanager.OOP.domain.coffee.Coffee;
import OOP.b_coffeemanager.OOP.domain.coffee.SeasonCoffee;
import OOP.b_coffeemanager.OOP.domain.purchase.Purchase;

//enum
//연관된 상수들의 집합
public enum OrderStatus {

	OK(200, "주문 생성 성공"),
	FAIL_SOLD_OUT(500, "재고 확보 실패로 인한 주문 취소"),
	FAIL_FORCE(400, "판매자의 강제 주문 취소"),
	FAIL_SEASON(401, "판매 시즌이 아닙니다.");
	
	private int code;
	private String desc;
	
	OrderStatus(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public boolean isOk() {
		return code == 200;
	}
	
	public boolean isFail() {
		return code != 200;
	}
	
	public String desc() {
		return desc;
	}
	
	public int code() {
		return code;
	}

	public static OrderStatus determinStatus(Order order) {
		int orderCnt = order.getOrderCnt();
		Coffee coffee = order.getCoffee();
		
		if (coffee instanceof SeasonCoffee seasonCoffee) {
			if (!seasonCoffee.isSeason()) {
				return OrderStatus.FAIL_SEASON;
			}
		}
		
		if (orderCnt > coffee.getStock()) {
			Purchase purchase = new Purchase(coffee, orderCnt);
			if (!purchase.proceed()) {
				return OrderStatus.FAIL_SOLD_OUT;
			}
		}
		
		return OK;
	}
	
}
