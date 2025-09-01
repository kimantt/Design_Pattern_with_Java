package OOP.e_game.event;

import java.util.Scanner;

import OOP.e_game.character.Player;

public interface Event {

	boolean proceed(Player player, Scanner sc);
	
}
