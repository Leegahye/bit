/*
 * 클래스
 * 1)새로운 데이터 타입 정의
 * 2)함수를 묶는 용도
 */
package exam.oop;

import java.util.Scanner;

//학생의 성적 데이터를 표현하는 데이터 타입 정의.
//새로운 데이터 타입의 이름은 Score
//=> 개발자가 임의적으로 정의하는 데이터타입 => 사용자 정의 데이터타입

class Score{
	String name;
	int kor;
	int mat;
	int eng;
  int tot;
	float avg;
}
public class Test01 {
	
	public static void main(String[] args){
		Score[] score = new Score[3];
		
		Scanner sc = new Scanner(System.in);
		Score s;
		AAA:
		while(true){
			for(int i = 0; i<score.length; i++){
				s=new Score();
				
				System.out.print("이름 : ");
				s.name = sc.nextLine();		
				
				System.out.print("국어 : ");
				s.kor = Integer.parseInt(sc.nextLine());
				
				System.out.print("영어 : ");
				s.eng= Integer.parseInt(sc.nextLine());
				
				score[i] = s;
			}	
			for(int i = 0; i<score.length; i++){
				s = score[i];
				System.out.println(s.name + ","+s.kor+","+s.eng);
			}
		
		 System.out.print("계속 입력하시겠습니까?(y/n)");
			if(sc.nextLine().equals("n")){
				break;
			}else{
				continue AAA;
			}
		}
		
}

	public static void main03(String[] args) {
		Score[] score = new Score[100];
		int count = 0;
		
		Scanner sc = new Scanner(System.in);
		
			Score s;//반복문 내에서 인스턴스 주소를 담기 위해 사용할 레퍼런스 변수
			
			for(int i = 0; i<score.length; i++){
				s = new Score();
				
				System.out.print("이름 : ");
				s.name = sc.nextLine();		
				
				System.out.print("국어 : ");
				s.kor = Integer.parseInt(sc.nextLine());
				
				System.out.print("영어 : ");
				s.eng= Integer.parseInt(sc.nextLine());
				
				System.out.print("수학 : ");
				s.mat = Integer.parseInt(sc.nextLine());

				s.tot = s.kor+s.eng+s.mat;
				s.avg = s.tot/3.0f;
				
				score[i] = s;
							
				count ++;
				
				System.out.print("계속 입력하시겠습니까?(y/n)");
				
				if(sc.nextLine().equals("n")){
					break;
				}	
			}
			for(int i = 0; i<count; i++){
				s = score[i];
				System.out.println(s.name+" 님의 "+"총점 : " + s.tot+" , 평균 : " + s.avg);
			}
		
	}
	
	public static void main02(String[] args) {
		//레퍼런스 배열 사용 전
		Score s1 = new Score();
		Score s2 = new Score();
		Score s3 = new Score();
		
	  //레퍼런스 배열 선언
		Score[] list = new Score[3];
		list[0] = new Score();
		list[1] = new Score();
		list[2] = new Score();
		
	  Score s = new Score();
	  s.name = "홍길동";
	  s.kor = 100;
	  s.eng = 100;
	  s.mat = 100;
	  s.tot = s.kor+s.eng+s.mat;
	  s.avg = s.tot/0.3f;
	}
	
	public static void main01(String[] args) {
	  int i; //정수 값을 담을 4byte 메모리를 준비
	  
	  //*사용자 정의 데이터 타입의 메모리를 준비하려면 배열처럼 new연산자를 사용해야 한다.
	  // 문법 : new 사용자정의데이터타입();
	  //*이렇게 준비된 메모리를 사용하려면 메모리의 주소를 변수에 저장해야 한다.
	  // 문법 : 사용자정의데이터타입 변수;
	  Score s = new Score();
	  s.name = "홍길동";
	  s.kor = 100;
	  s.eng = 100;
	  s.mat = 100;
	  s.tot = s.kor+s.eng+s.mat;
	  s.avg = s.tot/0.3f;
	}
	
	public static void main2(String[] args) {

		String[] name = new String[100];
		int[] kor = new int[100];
		int[] eng = new int[100];
		int[] mat = new int[100];
		int[] tot = new int[100];
		float[] avg = new float[100];
		int count = 0;
		
		Scanner sc = new Scanner(System.in);
			for(int i = 0; i<name.length; i++){
				System.out.print("이름 : ");
				name[i] = sc.nextLine();		
				
				System.out.print("국어 : ");
				kor[i] = Integer.parseInt(sc.nextLine());
				
				System.out.print("영어 : ");
				eng[i] = Integer.parseInt(sc.nextLine());
				
				System.out.print("수학 : ");
				mat[i] = Integer.parseInt(sc.nextLine());

				tot[i] = kor[i]+eng[i]+mat[i];
				avg[i] = tot[i]/3.0f;
				
				count ++;
				
				System.out.print("계속 입력하시겠습니까?(y/n)");
				if(sc.nextLine().equals("n")){
					break;
				}	
			}
			for(int i = 0; i<count; i++){
				System.out.println(name[i]+" 님의 "+"총점 : " + tot[i]+" , 평균 : " + avg[i]);
			}
		
}

}
