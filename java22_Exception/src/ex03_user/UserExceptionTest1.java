package ex03_user;

public class UserExceptionTest1 {

	public static void main(String[] args) {
		System.out.println("1.User 생성");
		User user = new User();
		try {
			user.calc(0, 10);
		}catch(Boom e) {
			System.out.println(e.getMessage());
		}
		System.out.println("4. 폭탄 처리 성공...");

	}

}

class User{
	public void calc(int x, int y)throws Boom {//임의의 값 x, y가 인자값... 호출시
		System.out.println("2.clac 함수 호출");
		if(x ==0)
			
		throw new Boom("x가 0이면 안되요... 분모가 될 숫자거든요.");
		//ArithmeticException을 발생시킨다...
		System.out.println("2.clac 함수 호출...x는 0이 아닙니다.");
		//연산이 진행...y/x
	}
}
class Boom extends Exception{

	public Boom() {
		this("x가 0이면 안되요... 분모가 될 숫자거든요.");
	}

	public Boom(String message) {
		super(message);
	}


	
}
