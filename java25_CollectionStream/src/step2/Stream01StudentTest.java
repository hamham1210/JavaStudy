package step2;
/*
 * 중간처리 연산자
 * map
 * mapToInt | mapToDouble
 * peek
 * distinct
 * filter
 * limit
 * 
 * 
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream01StudentTest {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("SCOTT", 90),
				new Student("Blake", 92),
				new Student("Smith", 83)
				);
		
		Stream<Student> studentStream = students.stream();
		
		
		//중간처리 연산자 mapToInt... 학생 객체를 점수로 매핑하는 기능...IntStream(점수로만 이뤄진 새로운 스트림)를 반환
		IntStream scoreStream =  studentStream.mapToInt(student-> student.getScore());
		//최종처리
		System.out.println("Result Avg 1"+scoreStream.average().getAsDouble());
		
		System.out.println("-------------------------Method Chaining----------------------------------");
		double avg=students.stream()
				.mapToInt(student-> student.getScore())
				.average()
				.getAsDouble();
		System.out.println("Result Avg 1"+avg);
		
		//map Stream내 값들을 변환해서 새로운 스트림을 생성하는 기능
		long count= students.stream()
		.map(student-> student.getName())
		.filter(student-> student.equals("SCOTT"))
		.peek(student-> System.out.println(student+ " peek"))
		.count();
		
		
		System.out.println("학생 수 "+ count);
		
		System.out.println("-------------------------anyMatch | filter와 구분----------------------------------");
		boolean find = students.stream()
				.anyMatch(s->s.getName().equals("King"));
		
		System.out.println("King이 멤버로 존재합니까?"+find);
	}

}


class Student{
	String name;
	int Score;
	@Override
	public String toString() {
		return "Student [name=" + name + ", Score=" + Score + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	public Student(String name, int score) {
		super();
		this.name = name;
		Score = score;
	}
}