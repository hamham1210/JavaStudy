package test1;

public class LambdaTest5 {

	public static void main(String[] args) {
		Fighter f = new Fighter();
		// 실행문이 하나 일때
//		f.action(()->System.out.println("드론을 이용해서 공중공격한다."););
		
		f.action(()-> {
			System.out.println("드론을 이용해서 공중공격합니다.");
			System.out.println("주요 건물을 타겟으로 방어전선을 구축...공격을 개시합니다.");
		});
		
		f.action((a,b)->{
			int right = a*100;
			int left = b+20;
			System.out.println("오른쪽으로 + " +right +"km이동합니다.");
			System.out.println("오른쪽으로 + " + left +"km이동합니다.");
		});
	}
	
}

@FunctionalInterface
interface Attackable{
	void attack();//인자값 없고 | 반환타입 없다.
}
@FunctionalInterface
interface Moveable{
	void move(int right, int left);//인자값 2개 | 반환타입 없다.
}

class Fighter{
	public void action(Attackable a) {
		a.attack();
	}
	public void action(Moveable b) {
		b.move(100,200);
	}
}