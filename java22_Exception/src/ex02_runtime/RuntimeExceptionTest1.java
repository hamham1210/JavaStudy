package ex02_runtime;
/*
 * try-catch구문은 여러개의 에러를 잡을 수 있다.
 * 단, 하나의 cathch문만 돌아감.-->큰 예외 순으로 잡아야한다. 거꾸로는 에러난다.
 */
public class RuntimeExceptionTest1 {

	public static void main(String[] args) {
		String[] str= {
				"Hello",
				"No, I mean it",
				"Nice to meet you"
		};
		int i = 0;
		while(i<=3) {
			try {
			System.out.println(str[i]);
			}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Nice Catch");
			}
			catch(NullPointerException e) {//객체 생성하지 않고 멤버 접근 했을 때 발생...
				System.out.println("NullPintException ... Nice Catch");
				}
			catch(ArithmeticException e) {//분모를 0으로 했을 때 발생하는 것
				System.out.println("ArithmeticException... ㅖ예해핟ㄴ");
				}
			i++;
		}
		System.out.println("The end...");
	}

}
