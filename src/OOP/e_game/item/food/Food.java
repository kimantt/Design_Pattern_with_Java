package OOP.e_game.item.food;

public class Food {

	private String name;
	private int heal;
	private String effect;

	public Food(String name, int heal, String effect) {
		this.name = name;
		this.heal = heal;
		this.effect = effect;
	}

	public String getName() {
		return name;
	}
	
	public int getHeal() {
		return heal;
	}

	public String getEffect() {
		return effect;
	}

}
