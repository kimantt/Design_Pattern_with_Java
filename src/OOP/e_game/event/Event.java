package OOP.e_game.event;

import java.util.Scanner;

import OOP.e_game.character.Player;

public interface Event {

	void proceed(Player player, Scanner sc);
	
}
