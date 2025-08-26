package OOP.b_coffeemanager.OOP.domain.order;

//enum
//연관된 상수들의 집합
public enum OrderStatus {

	OK(200, "주문 생성 성공"),
	FAIL_SOLD_OUT(500, "재고 확보 실패로 인한 주문 취소"),
	FAIL_FORCE(400, "판매자의 강제 주문 취소");
	
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
	
}
