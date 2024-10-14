package com.web.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.spring.entity.Custom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

//Spring Framework에서 빈으로 제공되는 것들을 사용하기 위해서는 CommandLineRunner!!상속 받아서 쓰기
@SpringBootApplication
public class Boot04JpaApplication implements CommandLineRunner {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Override
	public void run(String... args) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			/*
			 * 저장 ..persist Custom c= new Custom(); c.setName("김종각2");
			 * c.setPassword("4321"); c.setEmail("kim@google.com");
			 * entityManager.persist(c);
			 */
			// 검색
			/*
			 * Custom find1 = entityManager.find(Custom.class,1);
			 * System.out.println("1번에 해당하는 정보 :"+find1);
			 */
			// 삭제..delete
			/*
			 * Custom delete = entityManager.find(Custom.class, 3);
			 * entityManager.remove(delete);
			 */
			/*
			 * 트랜잭션 내에서 같은 객체에 대해 여러번 SELECT 질의를 하는 경우 쿼리는 한 번만 발생된다. 1차 캐시에 객체가 없다면 SELECT
			 * 쿼리 발생하여 가져온 객체를 1차 캐시에 저장한다. 그 후 나머지 질의는 1차 캐시에 있는 객체를 그대로 반환하기 때문에 쿼리가 발생하지
			 * 않는다. Custom find2 = entityManager.find(Custom.class, 2);
			 * System.out.println("2번에 해당하는 정보 :"+ find2); Custom find22 =
			 * entityManager.find(Custom.class, 2); if(find2==find22)
			 * System.out.println("동일한 객체입니다.~~!!");
			 */
			/*
			// persist + find
			Custom c = new Custom();
			c.setName("James");
			c.setPassword("7777");
			c.setEmail("james@kosta.com");
			
			entityManager.persist(c);
			
			Custom find4 = entityManager.find(Custom.class, 4);
			System.out.println("4번에 해당하는 정보 :" + find4);
			*/
			//수정.. update가 존재하지 않는다.
			//4번 고객의 정보를 수정
			/*
			Custom find4 = entityManager.find(Custom.class, 4);
			find4.setPassword("9999");//비번을 변경
			System.out.println("4번 고객의 정보 :"+find4);
			*/
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			entityManager.close();
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(Boot04JpaApplication.class, args);
	}

}