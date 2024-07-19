package com.edu.workshop;

import java.util.Scanner;

public class Game {
	
	    int gameType;
	    int totalWinCnt;

	    Player player;


	    public Game(){
	    	
	    	Scanner sc = new Scanner(System.in);
	        player = new Player();
	        
	        //게임 타입 입력
	        gameType = sc.nextInt();
	        
	        if (gameType == 1) {
	            totalWinCnt = 3;
	        }
	        else if (gameType == 2) {
	            totalWinCnt = 2;
	        }
	        else {
	            totalWinCnt = 1;
	        }
	    }


	    public void runGame(){

	    	while(true) {
	    		
	    		if( (player.getWinCnt() >= totalWinCnt) || (player.getLoseCnt() >= totalWinCnt)) break;
	    		
	        	//player 입력
	            System.out.print("가위바위보 중 하나 입력: ");
	            Scanner sc = new Scanner(System.in);
	            player.setPlayerInput(sc.nextLine());
	            
	            //computer random 하게 생성
	            int comChoice =(int) (Math.random() * 3) + 1;

	            int in = player.getPlayerInput();

	            if (comChoice == in) {
	                System.out.println("비겼습니다!!!");
	            } 
	            else if ((comChoice == 1 && in == 2) || (comChoice == 2 && in == 3) || (comChoice == 3 && in == 1)) {
	                System.out.println("이겼습니다!!!");
	                player.addWinCnt();
	            } 
	            else if ( (comChoice ==1 && in ==3) || (comChoice ==2 && in ==1) || (comChoice ==3&& in ==2)) {
	                System.out.println("졌습니다!!!");
	                player.addLoseCnt();
	            }
	            
	        }
	    }

	    public String resultPrint(){

	        int win = player.getWinCnt();
	        int lose = player.getLoseCnt();

	        String result = "";
	        if (win == lose) {
	            result = "무승부";
	        } else if (win > lose) {
	            result = "컴퓨터 패";
	        } else {
	            result = "컴퓨터 승";
	        }

	        return "\n### " + result + "!!!";
	    }
	    
	}

