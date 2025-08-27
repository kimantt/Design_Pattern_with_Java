package OOP.c_templatemethod;

import java.util.Scanner;

public class Run {

	// Player 캐릭터의 공격 가중치는 atk/2 ~ atk*3
	// Monster의 공격 가중치는 atk ~ atk*2
	// Warrior 캐릭터의 공격 가중치는 atk ~ atk*4
	//                방어 가중치는 damage의 30%를 감소시킴
	// Thief 캐릭터의 공격 가중치는 atk/2 ~ atk*5
	// 50% 확률로 적의 공격을 무효화 한다
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Character player = new Warrior("플레이어", 200, 30, 10);
		Character monster = new Monster("몬스터", 200, 30, 10);
		
		System.out.println("[전투이벤트]" + monster.getName() + " 등장!");
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
			
			player.attack(monster);
			monster.attack(player);
			System.out.println("------------------------------------");
			System.out.println("[" + player.getName() + " HP] : " + player.getCurrentHp());
			System.out.println("[" + monster.getName() + " HP] : " + monster.getCurrentHp());
		}

	}

}
