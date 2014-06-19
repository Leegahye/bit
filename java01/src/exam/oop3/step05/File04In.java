package exam.oop3.step05;

import java.io.FileReader;
import java.io.IOException;

/*
 * FileReader
 *  - 문자 데이터를 읽을 때 사용하는 클래스
 */
public class File04In {

	public static void main(String[] args) throws IOException{
		FileReader in = new FileReader("file04.txt");
		
		char[] buf = new char[100];
		int readSize = 0;
		readSize = in.read(buf,3,5);//3번째부터 5개 출력하라
		System.out.print(buf);

		in.close();//읽고 나서도 꼭 닫아야 함!!
	}
	public static void main01(String[] args) throws IOException{
		FileReader in = new FileReader("file04.txt");
		System.out.println((char)in.read());
		System.out.println((char)in.read());
		
		char[] buf = new char[4];
		int readSize = 0;
		readSize = in.read(buf); //readSize->실제 읽은 사이즈
		System.out.print(buf);
		System.out.println(","+readSize);
		
		readSize = in.read(buf);
		System.out.print(buf);
		System.out.println(","+readSize);
		
		readSize = in.read(buf);
		System.out.print(buf);
		System.out.println(","+readSize);
		
		readSize = in.read(buf);
		System.out.print(buf);
		System.out.println(","+readSize);
		
		in.close();//읽고 나서도 꼭 닫아야 함!!
		
	}

}
