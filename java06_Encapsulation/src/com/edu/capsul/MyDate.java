package com.edu.capsul;

import java.time.Month;

//오늘 날짜정보를 저장하는 클래스
public class MyDate {

	int month;
	int day;

	public int getMonth() {
		return month;
	}

	 public void setMonth(int month) {
		if (month != 0 && month <= 12) {
			this.month = month;
		} else {
			errorMessage("월");
		}

	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		switch (month) {
		case 2:
			if (day >= 1 && day <= 28) {
				this.day = day;
			} else {
				errorMessage("일");
			}

			break;

		case 4:
		case 6:
		case 9:
		case 11:
			if (day >= 1 && day <= 31) {
				this.day = day;
			} else {
				errorMessage("일");
			}
			break;
		default:
			if (day >= 1 && day <= 31) {
				this.day = day;
			} else {
				errorMessage("일");
			}
		}

	}
	
	public void errorMessage(String value) {
		System.out.println(value+"를 다시 확인해주세요.");
	}
}
