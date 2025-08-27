package OOP.c_templatemethod;

import java.util.Random;

public class Monster extends Character {

	Random random = new Random();
	
	public Monster(String name, int hp, int atk, int def) {
		super(name, hp, atk, def);
	}

	// Monster의 공격 가중치는 atk ~ atk*2
	@Override
	protected int calAttackWeight() {
		return random.nextInt(atk, atk*2);
	}

	@Override
	protected int calDefenseWeight(int damage) {
		return damage - (damage * (def / 100));
	}
	
}
