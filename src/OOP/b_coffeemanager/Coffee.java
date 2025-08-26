package OOP.b_coffeemanager;

public class Coffee {

	private String name;
	private int price;
	private int cost;
	private int stock;
	private int safetyStock;
	private int salesCnt;
	
	public Coffee(String name, int price, int cost, int stock, int safetyStock, int salesCnt) {
		this.name = name;
		this.price = price;
		this.cost = cost;
		this.stock = stock;
		this.safetyStock = safetyStock;
		this.salesCnt = salesCnt;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getSalesCnt() {
		return salesCnt;
	}

	public void setSalesCnt(int salesCnt) {
		this.salesCnt = salesCnt;
	}
	
	public void addSalesCnt(int cnt) {
		this.salesCnt += cnt;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getCost() {
		return cost;
	}

	public int getSafetyStock() {
		return safetyStock;
	}
	
	public void deductStock(int cnt) {
		this.stock -= cnt;
	}
	
	public void addStock(int cnt) {
		this.stock += cnt;
	}
}
