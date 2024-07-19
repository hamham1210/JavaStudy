package test1;

public class GenericTest01 {
	public static void main(String[] args) {
		Box box = new Box();
		box.content = "곰돌이 인형";
		String bearDoor = (String)box.selectContent();
		//object타입으로 넣으면 object casting이 선행되어야 다른 타입으로 꺼낼 수 있다.
	}

}
//Generic사용 안함
//Box 뭐든지 담을수 있도록 설계했을때의 상황...
/*
 * 1. 뭐든지 담긴다.
 * 2. 꺼낼때마다 Object casting 해줘야한다.
 */
class Box{
	 Object content;// box에 뭐든지 담을 수 있기 위해서는 Object로 지정해야한다.
	
	public Object selectContent() {
		return content;//content안에서 뭐든지 꺼내는 함수
	}
}