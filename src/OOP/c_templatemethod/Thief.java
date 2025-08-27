package OOP.c_templatemethod;

import java.util.Random;

public class Thief extends Character {

	Random random = new Random();
	
	public Thief(String name, int hp, int atk, int def) {
		super(name, hp, atk, def);
	}

	// Thief 캐릭터의 공격 가중치는 atk/2 ~ atk*5
	@Override
	protected int calAttackWeight() {
		return random.nextInt(atk/2, atk*5);
	}

	// 50% 확률로 적의 공격을 무효화 한다
	@Override
	protected int calDefenseWeight(int damage) {
		if (random.nextInt(0, 2) == 0) {
			System.out.println("[Thief 특성 발동] 공격이 빗나갑니다.");
			return 0;
		}
		return damage - (damage * (def / 100));
	}

}
