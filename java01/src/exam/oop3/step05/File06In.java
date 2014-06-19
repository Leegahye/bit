package exam.oop3.step05;
/*
 * Character Stream : 입출력 시 유니코드 변환을 자동으로 수행
 * Binary Stream : 변환없이 바이트 데이터를 그대로 읽고 쓴다.
 */
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;


public class File06In {

	
	public static void main(String[] args) throws IOException{
		/*
		 * 바이너리(바이트) 스트림 : FileInputStream의 읽기원리
		 * - 읽고 쓸 때 변환처리를 하지 않는다. 순수하게 바이트 그대로 읽고 쓴다.
		 */
		FileInputStream in  = new FileInputStream("file04.txt");
		
		int b;
		while((b = in.read())!= -1){
			System.out.println(Integer.toHexString(b));
		}
		in.close();
	}
	
	public static void main01(String[] args) throws IOException{
		/*
		 * 문자 스트림 : FileReader의 읽기원리
		 * - 읽을 때 Unicode로 변환하여 값을 리턴.
		 * - 참고 : 쓸 때는 Unicode를 내부에 정의된 문자 집합으로 변환한 후 출력한다.
		 */
		FileReader in  = new FileReader("file04.txt");
		
		int ch;
		while((ch = in.read())!= -1){
			System.out.println(Integer.toHexString(ch));
		}
		in.close();
	}

}
