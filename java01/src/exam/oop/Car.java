
package exam.oop;

public class Car {
	//공통데이터 => 클래스변수
	static int count;
	
	//클래스변수 초기화 = >static블록
	static{
	/*car.은 생략가능*/	count = 100;
	}
	
	//개별데이터 => 인스턴스 변수
	int serialNo;
	String model;
	String carNo;
	int cc;
	int weight;
	int capacity;
	
	//인스턴스 변수 초기화 => 생성자
	public Car(String model, String carNo){
		this.serialNo = ++count;/*Car. 같은 클래스 내에 존재하기때문에 생략가능*/
		this.model = model;
		this.carNo = carNo;
	}
	
	
}
