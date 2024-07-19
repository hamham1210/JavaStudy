package com.edu.workshop.test;

import com.edu.workshop.Game;

public class GameTest {

	 public static void main(String[] args) {

	        System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
	        System.out.println("1. 5판 3승");
	        System.out.println("2. 3판 2승");
	        System.out.println("3. 1판 1승");
	        System.out.print("번호를 입력하세요.");

	        Game game = new Game();

	        //게임 시작
	        game.runGame();

	        //게임의 결과 출력
	        System.out.println(game.resultPrint());
	    }

	}


