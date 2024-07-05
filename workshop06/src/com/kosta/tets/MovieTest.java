package com.kosta.tets;

import java.util.Scanner;

import com.kosta.service.MovieMgr;
import com.kosta.vo.Movie;

public class MovieTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. 영화 추가 2. 영화 검색 3. 영화 삭제 4.전체 영화 보기");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				addMovie();
				break;

			case 2:
				searchMovie();
				break;

			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:
				sc.close();
				return;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}

	private static void addMovie() {
		System.out.println("추가 할 영화의 정보를 입력해주세요.");
		Scanner sc = new Scanner(System.in);
		System.out.println("영화 제목");
		String title = sc.next();
		System.out.println("영화 감독");
		String director = sc.next();
		System.out.println("영화 평점");
		int grade = sc.nextInt();
		System.out.println("영화 장르");
		String genre = sc.next();
		System.out.println("영화 소개");
		String summary = sc.next();

		Movie m = new Movie(title, director, grade, genre, summary);

		MovieMgr.getInstance().addMovie(m);
		System.out.println(title + "영화 추가 성공");
	}

	private static void searchMovie() {
		while (true) {
			System.out.println("1. 영화 제목 2. 영화 감독 3. 영화 평점 4. 영화 장르 5. 영화 소개 6. 영화 전체");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			switch (input) {
			case 1: {
				String title = sc.next();
				MovieMgr.getInstance().searhctitle(title);
				break;
			}
			case 2: {
				MovieMgr.getInstance().searchDirector();
				break;
			}
			case 3: {
				MovieMgr.getInstance().searchGenre();
				break;
			}
			case 4: {
				MovieMgr.getInstance().searchAMovie();
				break;
			}
			default:
				System.out.println("입력을 확인해주세요.");
				break;
			}

		}
	}
}
