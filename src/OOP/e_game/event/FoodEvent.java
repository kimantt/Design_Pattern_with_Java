package OOP.e_game.event;

import java.util.Random;
import java.util.Scanner;

import OOP.e_game.character.Player;
import OOP.e_game.item.food.Food;
import OOP.e_game.item.food.FoodData;

public class FoodEvent implements Event {

	@Override
	public void proceed(Player player, Scanner sc) {
		Random random = new Random();
		
		FoodData[] datas = FoodData.values();
		int index = random.nextInt(0, datas.length);
		Food food = datas[index].create();
		
		System.out.println("[먹거리 발견 이벤트]" + food.getName() + " 발견!");
		player.heal(food.getHeal());
		System.out.println(food.getName() + "을(를) 먹습니다.");
		System.out.println(food.getEffect());
		System.out.println("HP를 회복했습니다!");
		System.out.println("------------------------------------");
		System.out.println("[" + player.getName() + " HP] : " + player.getCurrentHp());
	}

}
