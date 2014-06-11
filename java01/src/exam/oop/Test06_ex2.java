/*
 * 클래스 변수와 스태틱 블록의 용도
 * 인스턴스 변수와 생성자의 용도
 * - 
 */
package exam.oop;

public class Test06_ex2 {
	public static void main(String[] args) {
		Car c1 = new Car("소나타","경기55가1234");
		Car c2 = new Car("소나타","서울30오1244");
		Car c3 = new Car("소나타","광주30허1111");
		printCarInfo(c1);
		printCarInfo(c2);
		printCarInfo(c3);	
	}
	//인스턴스의 주소(객체)가 넘어온다.
	static void printCarInfo(Car c){
		System.out.println(c.serialNo+","+c.model+","+c.carNo);
	}

}
