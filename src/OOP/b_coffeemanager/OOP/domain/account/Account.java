package OOP.b_coffeemanager.OOP.domain.account;

public class Account {

	private int balance;
	private int sales;
	private int expense;
	
	private static Account instance;
	
	public static Account getInstance() {
		if (instance == null) {
            instance = new Account();
        }
		return instance;
	}
	
	private Account() {
		this.balance = 100000;
		this.sales = 0;
		this.expense = 0;
	}
	
	public int getBalance() {
		return balance;
	}
	public int getSales() {
		return sales;
	}
	public int getExpense() {
		return expense;
	}
	
	public void registSales(int price) {
		this.balance += price;
		this.sales += price;
	}
	
	public boolean registExpenses(int price) {
		if (price > balance) {
			return false;
		}
		
		this.balance -= price;
		this.expense += price;
		return true;
	}
}
