/*
 * 함수 => 객체지향에서는 "메서드"라 부른다.
 *  -명령어들을 기능단위로 묶은 것.
 *  -명령어들을 관리하기 쉽다.
 *  -쉽게 재사용 할 수 있다.
 *  
 *  -문법
 *    리턴하는데이터의타입 함수명(값을 받을 변수선언, ...){명령들}
 *  -함수에서 값을 받기위해 선언하는 변수 => 파라미터
 *   int plus(int a, int b){return a+b}
 *   파라미터: a,b
 *  -함수를 호출할 때 넘겨주는 값 -> argument
 *   int result = plus(10,20);
 *   아규먼트(인자):10,20
 *    
 *  - ex1) void 리턴, 파라미터 없음.
 *  			 void print(){...}
 *    ex2) void, 파라미터 있음.
 *         void print(String msg){...}
 *    ex3) 리턴 있음. 파라미터 없음
 *         String getName(){return "okok";}
 *    ex4) 리턴 있음.  파라미터 있음
 *    		 int plus(int a, int b){return a+b;}
 */
package exam.oop;

import java.util.Scanner;

public class Test01_ex2 {
	
	static boolean isContinue(Scanner sc){
		
		System.out.print("계속 입력하시겠습니까?(y/n)");
		
		if(sc.nextLine().equals("n"))
			return false;
		else
			return true;
	}
	
	static Person inputPerson(Scanner sc){
		
		Person p = new Person();
		System.out.print("이름 : ");
		p.name = sc.nextLine();
		System.out.print("직위 : ");
		p.grade = sc.nextLine();
		System.out.print("전화번호 : ");
		p.phoneNum = sc.nextLine();
		System.out.print("이메일 : ");
		p.email = sc.nextLine();
		System.out.print("회사 : ");
		p.company = sc.nextLine();
		
		return p;
	}
	
	static void printPerson(Person p){
		System.out.println("이름"+"\t직위"+"\t전화번호"+"\t\t이메일"+"\t\t\t회사");
		System.out.println(p.name+"\t"+ p.grade+"\t"+ p.phoneNum+"\t\t"+p.email+"\t\t"+ p.company);
		
	}
	
	public static void main(String[] args) {
		
		int count = 0;
		Person[] person = new Person[3];
		Person p;
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i<person.length; i++){
			person[i] = inputPerson(sc);
			count ++;
			if(!isContinue(sc))
				break;
		}

		for(int i=0; i<count; i++){
			p = person[i];
		}
	}
}
