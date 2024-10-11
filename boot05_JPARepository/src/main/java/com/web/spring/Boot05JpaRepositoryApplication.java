package com.web.spring;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.spring.entity.Custom;
import com.web.spring.repository.CustomRepository;

import jakarta.transaction.Transactional;

//CustomRepository를 주입...Spring Data JPA가 생성하는 빈을 여기서 가져다 쓴다...
@SpringBootApplication
public class Boot05JpaRepositoryApplication implements CommandLineRunner{

	//주입된 해당 빈을 사용해서 CRUD작업을 다 할 수 있다.
	// 트랜잭션 단위로...EntityManager가 내부적으로 모든 일을 처리할 것이다.
	@Autowired
	private CustomRepository customRepository;
	
	@Override
	@Transactional //jpa 메소드가 호출될 때 트랜잭션이 실행되고, 메소드가 종료될때 트랜잭션이 끝난다.
	public void run(String... args) throws Exception {
		/*
		Optional<Custom> ot = customRepository.findById(1);
		System.out.println(ot);
		*/
		/*
		Custom c =customRepository.findById(1).orElseThrow();
		System.out.println("1번 고객에 대한 정보"+c);
		*/
		// CustomRepository를 실제로 구현하고 있는 구현체를  출력
		/*
		 * jdk.proxy4.$Proxy115
		 * ::
		 * Proxy는 인터페이스를 구현하고 있는 객체를 동적으로 생성해주는 자바 기술
		 * 모든 자바 프레임워크 구현체들은 Proxy기술을 이용해서 만들어진다.
		
		System.out.println(customRepository.getClass().getName());
		 * */
		//2.새로운 Custom을 추가
		/*
		Custom c1 =new Custom();
		//c1.setName("제시카");
		c1.setEmail("jasc@naver.com");
		c1.setPassword("8888");
		c1.setRegDate(LocalDateTime.now());
		
		customRepository.save(c1);
		*/
		//3.방금 추가한 사람 삭제하기
		//삭제를 위해서 select질의 후 삭제.
		//customRepository.deleteById(5);
		/*
		//이 경우는 1차 캐시에 select정보가 있을 경우 해당 값을 1차캐시에서 찾아서 DB호출이 위의 메소드보다 덜 일어난다.
		Custom delete= customRepository.findById(2).orElseThrow();
		customRepository.delete(delete);
		*/
		
		//4. 수정하기...update함수는 따로 제공되지 않는다.
		//대신 Entity정보와 스냅샷 정보가 다를때 트랙잭션이 완료되는 시점에 이걸 감지하고 update가 자동으로 호출
		/*
		Custom updateC= customRepository.findById(6).orElseThrow();
		System.out.println("update하기 전>>"+updateC);//스냅샷에 저장된 정보
		
		updateC.setPassword("0000");//변경.. Entity정보가 변경
		System.out.println("update하기 후>>"+updateC);//트랜잭션이 끝내기 전에 Entity와 스냅샷 정보를 비교하여서 업데이트한다.
		//find는 트랜잭션 안에서 commit을 하지만 find는 트랜젝션과 연결되지않아서 어노테이션을 붙여주지 않는 경우 업데이트가 안된다.
	*/
		
		/*
		 * customRepository.findByNameLike("홍%") .forEach(c->System.out.println(c));
		 */
		//findByNameNot
		customRepository.findByNameNot("홍종각")
						.forEach(c->System.out.println(c));
		System.out.println("------------------------------------------------------");
		
		customRepository.findByCustomIdIn(List.of(1,7,10))
		.forEach(c->System.out.println(c));
		System.out.println("------------------------------------------------------");
		customRepository.findAll();
		
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Boot05JpaRepositoryApplication.class, args);
	}

	
}
