package OOP.e_game.item.equipment;

import java.util.Random;

public class Equipment implements DamageWeight {

	private String name;
	private int atk;
	private int def;
	private Slot slot;
	private String effect;
	private Random random = new Random();
	
	public Equipment(String name, int atk, int def, Slot slot, String effect) {
		this.name = name;
		this.atk = atk;
		this.def = def;
		this.slot = slot;
		this.effect = effect;
	}

	public String getName() {
		return name;
	}

	public Slot getSlot() {
		return slot;
	}

	public String getEffect() {
		return effect;
	}

	@Override
	public int calAttackWeight(int damage) {
		return random.nextInt(damage + atk, damage + (atk * 2));
	}

	@Override
	public int calDefenseWeight(int damage) {
		return damage - (damage * (def / 100));
	}

}
