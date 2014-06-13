package exam.oop2.step11;
/*
 * 인터페이스 구현
 *  - 인터페이스에 선언된 모든 메서드를 구현해야 한다.
 *  
 */

public class LeeInterviewee implements Interviewee{
	//Interviewer 클래스에 의해서 호출되는 메서드이다.
	//내가 등록한 객체의 메서드가 다른 객체에 의해 호출된다면 => "callback메서드"라 부른다.
	public void hi(){
		System.out.println("안녕");
	}
	public void bye(){
		System.out.println("바이");
	}
}
