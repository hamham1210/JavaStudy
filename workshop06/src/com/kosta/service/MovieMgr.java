package com.kosta.service;


import com.kosta.vo.Movie;


public class MovieMgr {

	private int index;
	public Movie[] movie;
	public int numberOfMovie;
	private static MovieMgr mgr = new MovieMgr();
	
	private MovieMgr() {
		this.movie = new Movie[0];
		index = 0;
		numberOfMovie = 0;
	};
	public static MovieMgr getInstance() {
		return mgr;
	}

	
	public void addMovie(Movie m) {
			if(index == movie.length) {
				System.out.println("추가할 영화가 없습니다.");
				return;
			}
			else{
				movie[index++] = m;
			System.out.println( "영화 추가 성공");
		}
	}
	
	
	public Movie[] searchAMovie() {
		
		if(numberOfMovie == 0) {
			System.out.println("영화가 없습니다.");
			
		}
		for(int i=0; i<numberOfMovie; i++) {
			System.out.println(movie[i]);
		}
		return movie;
	}
	
	public Movie[] searhctitle(String title) {
		if(numberOfMovie == 0) {
			System.out.println("영화가 없습니다.");
		}
		for(Movie m : movie) {
			if(m==null) break;
			System.out.println(m.getTitle());
		}
		return movie;		
	}

	
	public Movie[] searchDirector() {
		return null;
		
	}
	public Movie[] searchGenre() {
		return null;
		
	}
	
	public void deleteMovie() {
		
	}
	
	public int getSize() {
		return 0;
	}
	
}
