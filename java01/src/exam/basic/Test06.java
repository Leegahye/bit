/*
 * 6. 자바의 기본연산은 int 이다
 * -byte 끼리의 연산결과도 int
 * -short 끼리의 연산결과 int
 * -long 끼리의 연산결과 long
 * -{byte,short,char}>int>long>float>double
 */
package exam.basic;

public class Test06 {

	public static void main(String[] args) {
		byte b1 = 56;//값 56이 비록 32비트 정수값이지만 변수에 저장할 수 있다면 승인한다.
		//byte b2 = 128;//상수 128을 b2변수에 저장할 수 없다. 오류!
		
		//byte 끼리의 연산결과는 int이다.
		byte b2 = 56;
		byte b3 = 10;
		
	//기본연산은 int이기 때문에 byte값을 임시 int변수에 저장한 다음 계산수행
	//byte b4 = b2+b3; //내부적으로 b2와 b3값을 저장할 int 메모리가 준비된다.
		int i1 = b1+b2;
		
		short s1 = 10;
		short s2 = 20;
		//short s3 = s1+s2;//위와 똑같다.
		int i2 = s1+s2;
		
		//항상 같은 타입끼리만 연산가능
		int i3 = b1 + s1;//b1->int, s1->int
		long l1 = 30;
		long l2 = i1+l1; //i1 -> long
		
		float f1 = 3.14f;
		float f2 = f1+l1;//l1 -> float(실수가 우선)
		
		double d1 = 3.14;
		double d2 = b1 + s1 +i1 + l1 + f1 + d1;
		/*
		 * 자바 컴파일러는 위의 명령을 다음과 같이 변경한다.
		 * int t1 = b1;
		 * int t2 = s1;
		 * int t3 = t1+t2;
		 * int t4 = t3 + i1;
		 * long t5 = t4;
		 * long t6 = t5+l1;
		 * float t7 = t6;
		 * float t8 = t6 + f1;
		 * double t9 = t8;
		 * double t10 = t9+d1;
		 */
		/*
		 * Implicit Type Conversion(암시적 형변환)
		 * 서로다른 두 타입의 값을 연산하기 위해서 
		 * 둘 중 하나의 값을 다른 쪽에 맞추는 것.
		 * -암시적 형변환의 규칙
		 * 	 {byte,short,char} > int > long > float > double
		 */
	}

}
