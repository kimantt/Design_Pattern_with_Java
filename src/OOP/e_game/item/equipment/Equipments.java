package OOP.e_game.item.equipment;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Equipments {

	private final Map<Slot, Equipment> equipments;

	public Equipments() {
		equipments = new HashMap<Slot, Equipment>();
		equipments.put(Slot.WEAPON, EquipmentData.BASIC_WEAPON.create());
	}
	
	public void equip(Equipment equipment) {
		equipments.put(equipment.getSlot(), equipment);
	}
	
	public void unEquip(Slot slot) {
		if (slot.equals(Slot.WEAPON)) {
			equipments.put(Slot.WEAPON, EquipmentData.BASIC_WEAPON.create());
		}
		equipments.remove(slot);
	}
	
	public Collection<Equipment> findAll() {
		return equipments.values();
	}
	
	public Optional<Equipment> findBySlot(Slot slot) {
		return Optional.of(equipments.get(slot));
	}
	
	public Equipment getEquipment(Slot slot) {
		return equipments.get(slot);
	}
	
}
