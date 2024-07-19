package com.edu.game.test;

import java.util.Scanner;

import com.edu.game.Game;
import com.edu.game.Player;

public class GameLauncher {
	

	public static void main(String[] args) {
		Game game = new Game();
		
		game.gameInfo();
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();
		game.jcugeGame(type);
		game.playgame();
		
	}

}
