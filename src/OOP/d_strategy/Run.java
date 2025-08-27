package OOP.d_strategy;

import java.util.Random;
import java.util.Scanner;

import OOP.d_strategy.character.Monster;
import OOP.d_strategy.character.Player;
import OOP.d_strategy.item.Equipment;
import OOP.d_strategy.item.code.EquipmentData;

public class Run {

	public static void main(String[] args) {
		
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		Player player = new Player("플레이어", 200, 30, 10);
		Monster monster = new Monster("몬스터", 200, 30, 10);
		
		System.out.println("[전투이벤트]" + monster.getName() + " 등장!");
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
