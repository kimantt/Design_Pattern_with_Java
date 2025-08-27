package OOP.c_templatemethod;

public abstract class Character {

	private String name;
	protected int hp;
	protected int currentHp;
	protected int atk;
	protected int def;
	
	public Character(String name, int hp, int atk, int def) {
		this.name = name;
		this.hp = hp;
		this.currentHp = hp;
		this.atk = atk;
		this.def = def;
	}
	
	public void attack(Character target) {
		System.out.println("[" + name + "] 공격!");
		int damage = calAttackWeight();
		target.takeDamage(damage);
	}
	
	protected abstract int calAttackWeight();

	public void takeDamage(int damage) {
		damage = calDefenseWeight(damage);
		System.out.println("[ Damage ] : " + damage);
		this.currentHp -= damage;
		this.currentHp = Math.max(currentHp, 0);
	}
	
	protected abstract int calDefenseWeight(int damage);

	public String getName() {
		return name;
	}

	public int getCurrentHp() {
		return currentHp;
	}
	
	public boolean isDead() {
		return currentHp == 0;
	}
	
}
