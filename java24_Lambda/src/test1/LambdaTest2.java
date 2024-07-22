package test1;

public class LambdaTest2 {

	public static void main(String[] args) {
			Employee e = new Employee();
			e.work((a,b) ->{// 구현체
				double salary= b*4+100.0;
				return a+ "씨의 4주 급여는 " + salary;
			});
	}

}
class Employee{//workable을 매개변수로 Hasing
	public void work(Workable w)//함수형 인터페이스를 받아서 가짐 
		{String result = w.monthPayment("Smith", 2000.0);
		System.out.println("Result =>" + result);
	}
}
@FunctionalInterface
interface Workable{
	String monthPayment(String ename, double weekSal);
}