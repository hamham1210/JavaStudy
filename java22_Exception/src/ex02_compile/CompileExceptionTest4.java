package ex02_compile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.FileSystemNotFoundException;

class FileReading4{
	public void readFile(String fileName) throws FileSystemNotFoundException {
		System.out.println("2.readFile calling...");
try {
	FileReader reader = new FileReader(fileName);
	System.out.println("파일을 성공적으로 찾았습니다.");
		}
catch(FileNotFoundException e){
	System.out.println("파일을 찾지 못했습니다.");
//		e.printStackTrace();//에러내용을 출력해준다.(보안상으로 안 좋다.)
		System.out.println(e);
}
		//자바에서 파일을 읽어들이기 위해서는 FileReader 객체 생성
		
	}
}

public class CompileExceptionTest4 {

	public static void main(String[] args) {
		System.out.println("1. FileReading 객체 생성...");
		
		
		FileReading fr = new FileReading();
		fr.readFile("text.txt");
		
		System.out.println("3.파일을 잘 읽어들였습니다.");
	}

}
