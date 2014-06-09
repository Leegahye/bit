/*
 * 생성자
 * -인스턴스가 생성된 후 자동으로 호출되는 함수
 * -용도
 *   인스턴스 변수의 값을 초기화
 * -문법 : 리턴타입 없다. 함수이름이 클래스이름과 같다.
 *   클래스명(){...}
 *   
 */
package exam.oop;

public class Test02 {
	public static void main(String[] args) {
		
		//생성자 사용전
		/*Score2 s1 = new Score2();
		s1.name = "홍길동";
		s1.kor = 100;
		s1.eng = 100;
		s1.mat = 100;
		s1.tot = s1.kor+s1.eng+s1.mat;
		s1.avg = s1.tot/3.0f;*/
		
		//생성자 사용후
		Score2 s2 = new Score2("홍길동",100,100,100);		
		
  }
	
}
