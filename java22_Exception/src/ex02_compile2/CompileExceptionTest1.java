package ex02_compile2;
/*
 * 예외를 처리하는 방법 중 throws
 * 즉각적으로 예외를 처리 하지 않고 함수호출한 지점으로 돌아가서 던진다.
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;

class FileReading{
	public void readFile(String fileName) 
	{
		System.out.println("2.readFile calling...");
		FileReader reader = null;
try {
	reader = new FileReader(fileName);
	System.out.println("파일을 성공적으로 찾았습니다.");
		}
catch(FileNotFoundException e){
	System.out.println("파일을 찾지 못했습니다.");
//		e.printStackTrace();//에러내용을 출력해준다.(보안상으로 안 좋다.)
		System.out.println(e);
}
		//자바에서 파일을 읽어들이기 위해서는 FileReader 객체 생성
		finally {
			try{
		
			System.out.println("자료 반환...");
			
			reader.close();
	
		
			
		}}
	}

public class CompileExceptionTest1 {

	public static void main(String[] args) {
		System.out.println("1. FileReading 객체 생성...");
		FileReading fr = new FileReading();
		try {
			fr.readFile("text2.txt");
		}
		catch{
			
		}
		finally {
			
		}
		
		
		
		System.out.println("3.파일을 잘 읽어들였습니다.");
	}

}
