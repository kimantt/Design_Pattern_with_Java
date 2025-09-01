package OOP.e_game;

import java.util.Random;
import java.util.Scanner;

import OOP.e_game.character.Player;
import OOP.e_game.event.EquipmentEvent;
import OOP.e_game.event.Event;
import OOP.e_game.event.FoodEvent;
import OOP.e_game.event.CombatEvent;

public class Run {

	public static void main(String[] args) {
		
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		Player player = new Player("플레이어", 200, 30, 10);
		int day = 8;
		Event[] events = new Event[day];
		for (int i = 0; i < events.length - 1; i++) {
			int e = random.nextInt(0, 3);
			events[i] = switch (e) {
				case 0 -> new CombatEvent();
				case 1 -> new FoodEvent();
				case 2 -> new EquipmentEvent();
				default -> throw new IllegalArgumentException("Unexpected value: " + e);
			};
		}
		events[day - 1] = new CombatEvent();
		
		for (int i = 0; i < events.length; i++) {			
			System.out.println("------------------------------------");
			System.out.println((i+1) + "일차 모험이 시작되었습니다.");
			if (!events[i].proceed(player, sc)) {
				System.out.println("플레이어가 쓰러져서 모험이 종료됩니다.");
				System.out.print("엔터키를 누르세요.");
				sc.nextLine();
				break;
			}
			System.out.print("다음 날로 넘어가려면 엔터키를 누르세요.");
			sc.nextLine();
		}
		System.out.println("------------------------------------");
		System.out.println("모험이 종료되었습니다.");

	}

}
