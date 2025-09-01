package OOP.e_game.character;

import java.util.Optional;
import java.util.Random;

import OOP.e_game.item.equipment.Equipment;
import OOP.e_game.item.equipment.Equipments;
import OOP.e_game.item.equipment.Slot;

public class Player extends Character {

	private Random random = new Random();
	private Equipments equipments = new Equipments();
	
	public Player(String name, int hp, int atk, int def) {
		super(name, hp, atk, def);
	}

	@Override
	public void attack(Character target) {
		int damage = random.nextInt(atk, atk*3);
		System.out.println("[" + name + "] 공격!");
		for (Equipment e : equipments.findAll()) {
			damage = e.calAttackWeight(damage);
		}
		
		Optional<Equipment> optional = equipments.findBySlot(Slot.WEAPON);
		
		//
		
		if (optional.isPresent()) {
			System.out.println(optional.get().getEffect());
		}
		target.takeDamage(damage);
	}

	@Override
	public void takeDamage(int damage) {
		for (Equipment e : equipments.findAll()) {
			damage = e.calDefenseWeight(damage);
		}
		System.out.println("[ Damage ] : " + damage);
		this.currentHp -= damage;
		this.currentHp = Math.max(currentHp, 0);
	}

	public void equip(Equipment equipment) {
		equipments.equip(equipment);
	}
	
	public void heal(int point) {
		this.currentHp = Math.min(this.currentHp + point, hp);
	}
	
	public Equipment getEquipment(Slot slot) {
		return equipments.getEquipment(slot);
	}

}
