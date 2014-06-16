package exam.oop2.step12;

public class MyMonitor extends Monitor{
	//기존의 출력기능을 변경하고 싶다! => 재정의하라(오버라이딩)
	
	public void display(String contents) {
		System.out.println("/////////////////////////");
		System.out.println("///////오호라 모니터///////");
		System.out.println(".........................");
		System.out.println(contents);
		System.out.println("/////////////////////////");
	}
}
