package com.kosta.service;

import com.kosta.vo.Movie;
public class MovieMgr {
	private Movie[ ] movies = new Movie[10];
	private int index;
	
	//싱글톤...MovieMgr을 mgr이름으로 객체 생성...getInstance로 생성한 객체를 받아온다.
	private static MovieMgr mgr = new MovieMgr();
	private MovieMgr() {}
	public static MovieMgr getInstance() {
		return mgr;
	}
	
	public void add(Movie m) {
		movies[index++] = m;
	}
	
	public Movie[] search() {//모든 영화 다 가져오는 기능
		Movie[] nMovies = new Movie[index];
		for(int i=0; i<index; i++) {
			nMovies[i]=movies[i];
		}
		return nMovies;
	}
	
	public Movie[] search(String title) {
		int temp = 0;
		Movie[] nMovies = new Movie[index];
		
		for(Movie m : movies) {
			if(m==null) break;
			if(m.getTitle().contains(title)) {
				nMovies[temp++]=m;
			}
		}//null 값을 추리기 위해서 다시 for문을 동작시킴
		Movie[] realMovies = new Movie[temp];
		for(int i=0; i<temp; i++)
			realMovies[i] = nMovies[i];
	
		return realMovies;
	}

	public Movie[] searchDirector(String name) {
		int size = 0;
		for(int i=0; i<index ; i++) {
			if(movies[i].getDirector().contains(name)) size++; //2
		}//
		Movie[] nMovies = new Movie[size];
		for(int i=0; i<size; i++)
			if(movies[i].getDirector().contains(name)) {
				nMovies[--size] = movies[i];
			}
		return nMovies;
	}

	public Movie[] searchGenre(String genre) {
		int temp = 0;
		for(Movie m : movies) {
			if(m==null)
				break;
			if(m.getGenre().equals(genre)) {
				temp ++;
			}
		}
		Movie[] rearMovies = new Movie[temp];
		for(int i = 0; i<temp;) {
			for(Movie m : movies) {
				if(m==null)
					return rearMovies;
				if(m.getGenre().equals(genre)) 
					rearMovies[i++] = m;
			}
		}
		return rearMovies;
	}

	public void delete(String title) {
			for (int i=0; i<index; i++) {
				if(movies[i].getTitle().equals(title)) {
					for(int j = i; j<index; j++) {
						movies[j]= movies[j+1];//movies의 j번째에 있는 값을 j+1번째로 덮어씌운다.
					}
					movies[index]= null;
					index--;//index길이를 하나 줄인다.
					break;//모든 작업을 하고 제일 위 for문을 빠져나간다.
				}
			}
	}
	
	public int getSize() {
		return index;
	}
}







