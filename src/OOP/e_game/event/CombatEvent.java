package OOP.e_game.event;

import java.util.Random;
import java.util.Scanner;

import OOP.e_game.character.Monster;
import OOP.e_game.character.Player;
import OOP.e_game.item.equipment.Equipment;
import OOP.e_game.item.equipment.EquipmentData;

public class CombatEvent implements Event {
	
	@Override
	public void proceed(Player player, Scanner sc) {
		Random random = new Random();
		Monster monster = new Monster("몬스터", 200, 30, 10);
		
		System.out.println("[전투 이벤트]" + monster.getName() + " 등장!");
		boolean eventFlag = true;
		while (true) {
			if (player.isDead()) {
				System.out.println("------------------------------------");
				System.out.println("[결과] LOSE");
				break;
			}
			
			if (monster.isDead()) {
				System.out.println("------------------------------------");
				System.out.println("[결과] WIN");
				break;
			}
			
			System.out.print("------------------------------------");
			sc.nextLine();
			
			if (player.getCurrentHp() < 150) {
				EquipmentData[] datas = EquipmentData.values();
				int index = random.nextInt(0, datas.length);
				
				if (eventFlag) {
					Equipment equipment = datas[index].create();
					System.out.println(equipment.getName() + " 발견했습니다.");
					player.equip(datas[index].create());
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
