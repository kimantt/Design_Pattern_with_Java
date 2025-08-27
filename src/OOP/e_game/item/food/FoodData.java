package OOP.e_game.item.food;

public enum FoodData {
	
	BREAD("빵", 20, "쩝쩝."),
	JERKY("육포", 50, "질겅질겅."),
	STEAK("구운 고기", 100, "우걱우걱."),
	ELIXIR("파워엘릭서", 200, "꿀꺽꿀꺽.");
	
	private String name;
	private int heal;
	private String effect;
	
	private FoodData(String name, int heal, String effect) {
		this.name = name;
		this.heal = heal;
		this.effect = effect;
	}

	public Food create() {
		return new Food(name, heal, effect);
	}
}
