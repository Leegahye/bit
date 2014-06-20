package exam.oop3.step05;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * FileinputStream을 사용하여 숫자읽기
 *  - 다양한 크기의 숫자를 출력하기 위해서는 비트이동 연산자를 사용해야 하는 불편함이 있다.
 *  DataInputStream
 *   - 바이트 배열을 읽어서 기본 데이터형으로 값을 변환하여 리턴한다.

 */
public class File07In {
	
	//데이터 프로세싱 스트림 클래스 도입
	// - DataInputStream의 readXXX() 사용하여 값 읽기
	public static void main(String[] args) throws IOException{
		FileInputStream in = new FileInputStream("file07_x.dat");
		DataInputStream in2 = new DataInputStream(in);
		
		int kor = in2.readInt();
		int eng = in2.readInt();
		int mat = in2.readInt();
		
		in2.close();
		in.close();
		
		System.out.println(kor);
		System.out.println(eng);
		System.out.println(mat);
	}

	public static void main01(String[] args) throws IOException{
		FileInputStream in = new FileInputStream("file07.dat");
		int kor = 0,eng = 0,mat = 0;
		
		kor |= in.read() << 24;
		kor |= in.read() << 16;
		kor |= in.read() << 8;
		kor |= in.read();
		
		eng |= in.read() << 24;
		eng |= in.read() << 16;
		eng |= in.read() << 8;
		eng |= in.read();
		
		mat |= in.read() << 24;
		mat |= in.read() << 16;
		mat |= in.read() << 8;
		mat |= in.read();
		
		in.close();
		
		System.out.println(kor);
		System.out.println(eng);
		System.out.println(mat);
	}

}
