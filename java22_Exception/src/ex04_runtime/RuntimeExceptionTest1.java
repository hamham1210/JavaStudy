package ex04_runtime;
/*
 * try--예외 가능성있는 코드
 * catch-- 예외 발생시 잡는 코드
 * finally -- 예외 발생 상관 없이 무조건 실행되어야 하는 코드
 * 단, 하나의 cathch문만 돌아감.-->큰 예외 순으로 잡아야한다. 거꾸로는 에러난다.
 * Exception으로 한 번에 돌릴 수 있다.
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
			}catch(Exception e) {
			System.out.println("Nice Catch");
			}
			finally {
				//이 부분은 어떨 때 과연 사용할까...
				System.out.println("이 부분은 무조건 실행됩니다.. 예외 발생 여부와 상관없음");
			}
			i++;
		}
		System.out.println("The end...");
	}

}
