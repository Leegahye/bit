//개인공부
package exam.oop;

import java.util.Scanner;

class Score01{
	String name;
	int kor;
	int mat;
	int eng;
  int tot;
	float avg;
}
	public class Test {
		
		public static void main(String[] args){
			Score01[] score = new Score01[3];
			
			Scanner sc = new Scanner(System.in);
			Score01 s;
			AAA:
			while(true){
				for(int i = 0; i<score.length; i++){
					s=new Score01();
					
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

}