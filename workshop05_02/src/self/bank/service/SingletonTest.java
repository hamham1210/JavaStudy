package self.bank.service;

public class SingletonTest {

	public static void main(String[] args) {
//		BankService s1 = new BankService();
		BankService s1= BankService.getInstance();//참조변수
		BankService s2= BankService.getInstance();
		System.out.println(s1);
		System.out.println(s2);
		//getinstance로 만들어진 객체는 모두 같다.
		System.out.println(s2.toString());//참조변수는 toString이 생략되어있다.
	}

}
