package OOP.e_game.event;

import java.util.Random;
import java.util.Scanner;

import OOP.e_game.character.Player;
import OOP.e_game.item.equipment.Equipment;
import OOP.e_game.item.equipment.EquipmentData;

public class EquipmentEvent implements Event {

	@Override
	public boolean proceed(Player player, Scanner sc) {
		Random random = new Random();
		
		System.out.print("[보물상자 발견 이벤트] ");
		
		EquipmentData[] datas = EquipmentData.values();
		int index = random.nextInt(0, datas.length);
		Equipment equipment = datas[index].create();
		if (!equipment.getName().equals("주먹")) {
			System.out.print(equipment.getName() + " 발견! ");
			if (player.getEquipment(equipment.getSlot()) == null || player.getEquipment(equipment.getSlot()).getName().equals("주먹")) {
				player.equip(datas[index].create());
				System.out.println(equipment.getName() + "를 장착했습니다.");
			}
			else {
				System.out.println("[현재 장착 장비 : " + player.getEquipment(equipment.getSlot()).getName() + "]");
				System.out.print("장착하시겠습니까? (y/n) : ");
				String choice = sc.nextLine();
				if (choice.equals("y")) {
					player.equip(datas[index].create());
					System.out.println(equipment.getName() + "를 장착했습니다.");
				}
				else {
					System.out.println(equipment.getName() + "를 두고 떠납니다.");
				}
			}
		}
		else {
			System.out.println("\n보물상자에는 아무것도 없었습니다.");
		}
		return true;
	}

}
