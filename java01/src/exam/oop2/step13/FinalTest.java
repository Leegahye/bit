package exam.oop2.step13;
/*
 * final 사용법
 * 
 * 1)클래스의 final : 상속불가!
 *   final class A{}
 *   class B extends A{}//오류
 */
final class A{}
//class B extedns A{} //오류

/*
 * 2) 메서드의 final : 재정의 불가!(오버라이딩 불가)
 */
class A2{
	final void m(){} 
}
class B2 extends A2{
	//void m(){} //오류!오버라이딩 할 수 없음.
}

public class FinalTest {

	public static void main(String[] args) {
		/*
		 * 3)변수의 final:변수의 값이 단 한번만 할당될 수 있다. 
		 */
		int a = 10;
		a = 20;
		
		final int a2; //상수를 정의할 때 주로사용
		a2 = 10;//처음 값 할당 ok!
		//a2 = 20;//오류

	}

}

//클래스앞에 붙으면 : 상속x
//메서드앞에 붙으면 : 오버라이딩(재정의)x
//변수앞에 붙으면 : 변수값 변경 x