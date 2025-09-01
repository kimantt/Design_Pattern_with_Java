package OOP.e_game.event;

import java.util.Random;
import java.util.Scanner;

import OOP.e_game.character.Monster;
import OOP.e_game.character.Player;
import OOP.e_game.item.equipment.Equipment;
import OOP.e_game.item.equipment.EquipmentData;

public class CombatEvent implements Event {
	
	@Override
	public boolean proceed(Player player, Scanner sc) {
		Random random = new Random();
		Monster monster = new Monster("몬스터", 200, 30, 10);
		
		System.out.println("[전투 이벤트]" + monster.getName() + " 등장!");
		boolean eventFlag = true;
		while (true) {
			if (player.isDead()) {
				System.out.println("------------------------------------");
				System.out.println("[결과] LOSE");
				return false;
			}
			
			if (monster.isDead()) {
				System.out.println("------------------------------------");
				System.out.println("[결과] WIN");
				return true;
			}
			
			System.out.print("------------------------------------");
			sc.nextLine();
			
			if (player.getCurrentHp() < 150) {
				EquipmentData[] datas = EquipmentData.values();
				int index = random.nextInt(0, datas.length);
				
				if (eventFlag) {
					Equipment equipment = datas[index].create();
					System.out.print(equipment.getName() + "을(를) 발견했습니다. ");
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
					eventFlag = false;
				}
			}
			
			player.attack(monster);
			monster.attack(player);
			System.out.println("------------------------------------");
			System.out.println("[" + player.getName() + " HP] : " + player.getCurrentHp());
			System.out.println("[" + monster.getName() + " HP] : " + monster.getCurrentHp());
		}
	}

}
