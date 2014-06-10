/*
 * 자바의 메모리 관리
 *  - 4가지 영역으로 데이터를 관리한다.
 *  1)Method Area : 클래스가 놓여진다. 클래스변수.
 *  2)Heap : 인스턴스가 놓여진다.
 *  3)Stack : 로컬변수가 준비된다.
 *  4)Constant Pool : 상수값이 놓여진다.
 */
/*
 * 상수 풀 영역
 *  - 상수 객체가 준비되는 영역
 *  - 메모리 절약을 위해 같은값을 갖는 상수는 중복해서 생성되지 않는다.
 *  - 상수문자열 : "문자열"
 *    		내부적으로 String 인스턴스를 상수풀에 생성한다.
 *  - String#intern() : 상수 풀에 스트링 인스턴스 생성
 *  
 */ 

package exam.oop;

public class Test05_ex3 {

  public static void main(String[] args) {
	String s1 = new String("홍길동"); //힙 영역에 생성
	String s2 = new String("홍길동"); //힙 영역에 생성
	String s3 = "홍길동";//상수 풀 영역에 생성
	String s4 = "홍길동";//기존 상수 풀 영역에 생성된 객체를 가리킴
	
	if(s1 == s2){
		System.out.println("s1 == s2");
	}
	if(s3 == s4){
		System.out.println("s3 == s4");
	}
	String s5 = s1.intern();
	
	if(s3 == s5){
		System.out.println("s3 == s5");
	}
  }
}
