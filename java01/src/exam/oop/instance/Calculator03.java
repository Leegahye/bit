/*
 * 3. 인스턴스 변수 : 함수들의 중간작업 결과를 "개별적으로" 보관하는 변수.
 * - 문법 : 데이터타입 변수명;
 */
package exam.oop.instance;

public class Calculator03 {
	//인스턴스 변수 선언 - 데이터를 개별적으로 관리하고싶다면 클래스변수 대신 인스턴스 변수를 선언하라.
	int result;
	
	public static void init(Calculator03 that,int value){
		that.result = value;
	}
	public static void plus(Calculator03 that,int value){
		//Calculator02.result = Calculator02.result+value;
		that.result += value;
	}
	public static void minus(Calculator03 that,int value){
		that.result -= value;
	}
	public static void multiple(Calculator03 that,int value){
		that.result *= value;
	}
	public static void divide(Calculator03 that,int value){
		that.result /= value;
	}

}
