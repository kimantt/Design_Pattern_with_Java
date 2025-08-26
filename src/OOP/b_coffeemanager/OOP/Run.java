package OOP.b_coffeemanager.OOP;

import OOP.b_coffeemanager.OOP.domain.coffee.Coffee;
import OOP.b_coffeemanager.OOP.presentation.Menu;

public class Run {

	public static void main(String[] args) {
		Coffee[] coffees = {
				new Coffee("아메리카노", 1000, 500, 10, 3, 0),
				new Coffee("모카", 2000, 1000, 10, 3, 0),
				new Coffee("라떼", 2000, 1500, 10, 3, 0)
		};
		
		new Menu(coffees).menu();
	}

}
