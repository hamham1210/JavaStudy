package com.edu.confing;

public interface Config {
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver"; //public static final
	String URL = "jdbc:mysql://localhost:3306/emp?serverTimezone=Asia/Seoul&useUnicode=yes&characterEncoding=UTF-8";
	String USER = "root";
	String PASSWORD = "1234";
}
