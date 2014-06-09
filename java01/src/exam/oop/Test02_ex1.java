/*
 * 연습 : 인스턴스 생성
 *  - 클래스의 인스턴스를 생성하고 인스턴스에 값 할당 방법
 *  - Garbage : 인스턴스의 주소를 잃어버려 더 이상 사용할 수 없는 메모리
 *  - Garbage Collector : 가비지 수집기
 */
package exam.oop;

public class Test02_ex1 {
	public static void main(String[] args) {
		new Person();//인스턴스 생성 - 레퍼런스 변수 없다
		Person p1 = new Person(); //인스턴스 생성-> 그 주소를 변수에 보관, 레퍼런스 변수에 인스턴스의 주소 저장
		Person p2 = new Person();
		
		//레퍼런스 변수를 통해 인스턴스에 값 할당
		p1.name = "홍길동";
		p1.email = "hong@test.com";
		p2.name = "임꺽정";
		p2.email = "leem@test.com";
		
		// 레퍼런스변수를 통해 인스턴스의 변수 값을 추출.
		//레퍼런스.인스턴스변수명
		System.out.println(p1.name);
		System.out.println(p1.email);
		System.out.println(p2.name);
		System.out.println(p2.email);
		
		//레퍼런스 변수에 다른 주소 할당
		Person p3 = p2;
		System.out.println(p3.name);
		
		p1 = p2; 
		System.out.println(p1.name);
		//주소를 잃어버려 사용할 수 없는 인스턴스(Dangling Object => Garbage)
		//쓰지못하는 메모리(garbage)를 해제하는것 : Garbage Collector
		/*- Garbage collector 동작하는 원인
		 * 1)idle time
		 * 2)메모리 부족
		 */
		
		//용서받지 못 할 코드
		//null? 주소없음을 의미하는 값
		//Person p4 = null;//주소를 강제적으로 초기화.
		//System.out.println(p4.name);
		
		//용서받지 못 할 코드(by 컴파일러)s
		//Person p = new Board(); 
	}
	
}
