/*
 * 문제)
 *   이름, 직위, 전화번호, 이메일, 회사 정보를 입력받고 출력하는 프로그램을 짜시오.
 *   단 새 데이터 타입을 정의해서 값을 입력 받으시오.
 */
package exam.oop;

import java.util.Scanner;

//1.새 데이터 타입 정의:Address
class Person{
	String name;
	String grade;
	String phoneNum;
	String email;
	String company;
	
}
public class Test01_ex1 {
	
	public static void main(String[] args) {
		//2.Address 레퍼런스 배열 준비
		int count = 0;
		Person[] person = new Person[3];
		
		Person p;
		//3.키보드 입력 도구 준비
		Scanner sc = new Scanner(System.in);
		
		//4.주소정보 입력받기
		for(int i = 0; i<person.length; i++){
			p = new Person();
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
			
			person[i] = p;
			
			count ++;
			
			System.out.print("계속 입력하시겠습니까?(y/n)");
			
			if(sc.nextLine().equals("n")){
				break;
			}	
						
		}
		//5.주소정보 출력하기
		for(int i=0; i<count; i++){
			p = person[i];
			System.out.println("이름"+"\t직위"+"\t전화번호"+"\t\t이메일"+"\t\t\t회사");
			System.out.println(p.name+"\t"+ p.grade+"\t"+ p.phoneNum+"\t\t"+p.email+"\t\t"+ p.company);
			
		}
	  
  }

}
