package com.edu.collection1;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/*
 * 시스템 위에 탑재된 자바 관련 환경변수들이 어떤값이 있는지
 * 전부 가져와서 콘솔로 출력
 */
public class PropertiesTest {

	public static void main(String[] args) {
		Properties p = System.getProperties();
		//1.Enumeration 사용법
		/*
		Enumeration en = p.propertyNames();
		//키를 뽑고 키에 해당하는 값을 뽑는다.
		while(en.hasMoreElements()) {
			String key = (String)en.nextElement();
			String value = (String)p.get(key);
			
			System.out.println(key+"================"+value);
		}
		*/
		/*
		//2. Iterator 사용법
		Set set=p.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			//뽑은 것이 값이 아니고 키캆이다.
			String value = (String)p.get(key);
			System.out.println(key+"================"+value);
		}
		*/
		//3. 
		/*
		Iterator it =p.keySet().iterator();
		while(it.hasNext()) {
			String key = (String)it.next();
			//뽑은 것이 값이 아니고 키캆이다.
			String value = (String)p.get(key);
			System.out.println(key+"================"+value);
			
		}
		*/
		//4. for
		/*
		for(Object key : p.keySet()) {
			String value = (String)p.get(key);
			System.out.println(key+"================"+value);
		}
		*/
		//5.for Each. 람다식. java 1.8버전 이상에서맘 사용가능하다
		p.forEach((key,value)->
		System.out.println(key+"================"+value));
	}//main

}//class
