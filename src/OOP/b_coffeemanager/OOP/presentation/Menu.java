package OOP.b_coffeemanager.OOP.presentation;

import java.util.NoSuchElementException;
import java.util.Scanner;

import OOP.b_coffeemanager.OOP.domain.account.Account;
import OOP.b_coffeemanager.OOP.domain.coffee.Coffee;
import OOP.b_coffeemanager.OOP.domain.order.Order;
import OOP.b_coffeemanager.OOP.domain.payment.Payment;
import OOP.b_coffeemanager.OOP.domain.sale.SaleContext;

// presentation : 표현계층
// 서비스 외부의 요청을 받고 응답을 보내는 계층
public class Menu {
	
	private SaleContext saleContext = new SaleContext();
	private Coffee[] coffees;
	private Account account = Account.getInstance();

	public Menu(Coffee[] coffees) {
		this.coffees = coffees;
	}

	public void menu() {
		while (true) {
			
			try {
				Scanner sc = new Scanner(System.in);
				
				System.out.println("====== MENU ======");
				System.out.println("판매등록(1)");
				System.out.println("현황(2)");
				System.out.println("종료(3)");
				
				System.out.print("입력 : ");
				int menu = sc.nextInt();
				if (menu == 3) {
					System.out.println("system : 종료합니다.");
					break;
				}
				
				if (menu < 1 || menu > 3) {
					System.out.println("system : 잘못 입력하셨습니다.");
					continue;
				}
				
				if (menu == 1) {
					System.out.println("====== LIST ======");
					for (int i = 0; i < coffees.length; i++) {
						System.out.println(coffees[i].getName() + "(" + i + ")");
					}
					
					System.out.print("번호 : ");
					int drinkNo = sc.nextInt();
					System.out.print("수량 : ");
					int orderCnt = sc.nextInt();
					
					if (drinkNo < 0 || drinkNo > coffees.length) {
						System.out.println("system : 잘못 입력하셨습니다.");
						continue;
					}
					
					registOrder(drinkNo, orderCnt);

				} else {
					System.out.println("====== INFO ======");
					for (int i = 0; i < coffees.length; i++) {
						System.out.printf("%-10s 재고(%3d) 판매량(%3d) \n", coffees[i].getName(), coffees[i].getStock(), coffees[i].getSalesCnt());
					}
					System.out.printf("잔고 : %4d | 매출 : %8d | 지출 : %8d \n", account.getBalance(), account.getSales(), account.getExpense());
				}
				
			} catch(NoSuchElementException e) {
				System.out.println("system : 잘못 입력하셨습니다.");
				continue;
			} 
		}
	}

	private void registOrder(int drinkNo, int orderCnt) {
		Order order = Order.createOrder(coffees[drinkNo], orderCnt);
		
		if (order.getStatus().isFail()) {
			System.out.println("system : " + order.getStatus().desc());
			return;
		}
		
		Payment payment = saleContext.init(order);
		
		System.out.println("제품명 : " + coffees[drinkNo].getName() +
				"\n판매가 : " + coffees[drinkNo].getPrice() +
				"\n판매수량 : " + orderCnt +
				"\n결재금액 : " + payment.getPaymentPrice() +
				"\n남은 재고 : " + coffees[drinkNo].getStock());
	}
	
}
