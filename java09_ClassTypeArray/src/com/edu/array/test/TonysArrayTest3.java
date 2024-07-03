package com.edu.array.test;

import com.edu.vo.NoteBook;
import com.edu.vo.Programmer;

public class TonysArrayTest3 {

	public static void main(String[] args) {
		NoteBook[] noteBooks = { new NoteBook(111, "HP", 170), new NoteBook(222, "HP", 130),
				new NoteBook(333, "HP", 140), };
		//NoteBook배열 생성 및 배열에 값 할당
		Programmer bob = new Programmer("Bob");
		//Programmer 객체 생성
		bob.setNoteBooks(noteBooks);
		//bob이라는 Programmer 객체에 위에 할당한 NoteBook배열 값 할당
		System.out.println("Bob's NoteBook Info==============");
		NoteBook[] returns = bob.getNoteBooks();
		// NoteBook배열에 할당된 값을 가져오기 위해서 get함수를 써서 가져옴

		for (NoteBook nb : returns)
			nb.printNoteBookInfo();
		//NoteBook배열에서 get해온 return값을 for문으로 돌면서 가져옴 그 이후 그 값을 프린트함.
	}
}
