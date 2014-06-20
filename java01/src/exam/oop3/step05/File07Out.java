package exam.oop3.step05;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * FileOutputStream을 사용하여 숫자 출력
 * 
 *  *  DataOutputStream : 기본 데이터형의 값을 바이트 배열로 변환해주는 도우미 클래스
 *   - writeXXX();
 * 
 * 
 */
public class File07Out {

	//데이터 프로세싱 스트림 클래스 도입
		// - 기본 데이터형의 값을 바이트 배열로 쉽게 바꿀 수 있다.
		public static void main(String[] args) throws IOException{
			FileOutputStream out = new FileOutputStream("file07_x.dat");
			DataOutputStream out2 = new DataOutputStream(out);
			int kor = 900;
			int eng = 300;
			int mat = 550;
			
			out2.writeInt(kor);
			out2.writeInt(eng);
			out2.writeInt(mat);

			out2.close();
			out.close();

		}
		
	public static void main01(String[] args) throws IOException{
		FileOutputStream out = new FileOutputStream("file07.dat");
		
		int kor = 980;
		int eng = 300;
		int mat = 550;
		
		//1)마지막 바이트만 출력되기 때문에 데이터가 정확하게 저장되지 않는다.
		/*
		out.write(kor);
		out.write(eng);
		out.write(mat);*/
		
		//2)비트 이동 연산자를 통해 모든 바이트를 정확하게 저장한다.
		out.write(kor >> 24);//첫번째 바이트
		out.write(kor >> 16);//두번째 바이트
		out.write(kor >> 8);//세번째 바이트
		out.write(kor);//네번째 바이트
		
		out.write(eng >> 24);
		out.write(eng >> 16);
		out.write(eng >> 8);
		out.write(eng);
		
		out.write(mat >> 24);
		out.write(mat >> 16);
		out.write(mat >> 8);
		out.write(mat);
		
		
		out.close();
	}

}
