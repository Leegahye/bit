/*
 * 배열
 * -같은 종류의 메모리를 여러개 만드는것.
 */
package exam.basic;

import java.util.Scanner;

public class Array01_t01 {

	
	public static void main07(String[] args) {

		String[] name = new String[100];
		int[] kor = new int[100];
		int[] eng = new int[100];
		int[] mat = new int[100];
		int[] tot = new int[100];
		float[] avg = new float[100];
		int count = 0;
		
		//문제1)
		//다음과 같이 실행되도록 작성하시오!
		//이름은? 홍길동
		//국어? 100
		//영어? 100
		//수학? 100
		//계속 입력하시겠습니까?(y/n) y
	  //이름은? 임꺽정
		//국어? 100
		//영어? 100
		//수학? 100
	  //계속 입력하시겠습니까?(y/n) n
		//홍길동 님의 총점과 평균은 다음과 같습니다.
		//총점 = 300;
		//평균 = 100.0;
		//임꺽정 님의 총점과 평균은 다음과 같습니다.
		//총점 = 300;
		//평균 = 100.0;
		
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
	  
	public static void main06(String[] args) {

		String[] name = new String[3];
		int[] kor = new int[3];
		int[] eng = new int[3];
		int[] mat = new int[3];
		int[] tot = new int[3];
		float[] avg = new float[3];
		
		//문제1)
		//다음과 같이 실행되도록 작성하시오!
		//이름은? 홍길동
		//국어? 100
		//영어? 100
		//수학? 100
	  //이름은? 임꺽정
		//국어? 100
		//영어? 100
		//수학? 100
		//..... 
		//총 세명의 점수를 입력받고 출력
		//홍길동 님의 총점과 평균은 다음과 같습니다.
		//총점 = 300;
		//평균 = 100.0;
		
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
			
		}
		for(int i = 0; i<name.length; i++){
			System.out.println(name[i]+" 님의 "+"총점 : " + tot[i]+" , 평균 : " + avg[i]);
		}
}
	
	public static void main05(String[] args) {

		String[] name = new String[10];
		//int kor[] = new int[10]; //이것도 가능
		int[] kor = new int[10];
		int[] eng = new int[10];
		int[] mat = new int[10];
		int[] tot = new int[10];
		float[] avg = new float[10];
		
		//문제1)
		//다음과 같이 실행되도록 작성하시오!
		//이름은? 홍길동
		//국어? 100
		//영어? 100
		//수학? 100
		//홍길동 님의 총점과 평균은 다음과 같습니다.
		//총점 = 300;
		//평균 = 100.0;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		name[0] = sc.nextLine();		
		System.out.print("국어 : ");
		kor[0] = Integer.parseInt(sc.nextLine());
		System.out.print("영어 : ");
		eng[0] = Integer.parseInt(sc.nextLine());
		System.out.print("수학 : ");
		mat[0] = Integer.parseInt(sc.nextLine());

		tot[0] = kor[0]+eng[0]+mat[0];
		avg[0] = tot[0]/3.0f;
		
		System.out.println(name[0]+"님의 총점과 평균은 다음과 같습니다.");
		System.out.println("총점 : " + tot[0]);
		System.out.println("평균 : " + avg[0]);
	}
	
	public static void main03(String[] args) {
		//배열 선언과 동시에 초기값 할당
		//배열의 크기는 중괄호에 선언된 값들의 개수이다.
	  int[] arr = new int[]{10,20,30};
	  /*
	   다음은 오류
	   int[] arr2 = new int[3];
	   arr2 = {10,20,30};
	   */
	  
	 /* 다음은 허용!
	  int[] arr3;
	  arr3 = new int[]{10,20,30};
	  */
	
	  for(int i = 0; i<arr.length; i++){
	  	System.out.println(arr[i]);
	  }
	  
	 }
	
	public static void main02(String[] args) {
	  int[] arr = new int[3];
	  //new int[3] => 연속된 4byte int형 메모리 3개 준비
	  //int[] arr -> int배열의 주소를 저장하는 레퍼런스(변수)
	  //arr = 20; //주소가 아닌 값을 넣을 수 없다. 임의의 주소도 넣을 수 없다.
	  arr[0] = 10;
	  arr[1] = 20;
	  arr[2] = 30;
	  //arr[3] = 40;
	  
	  for(int i = 0; i<arr.length; i++){
	  	System.out.println(arr[i]);
	  }
	  
	 }
	public static void main04(String[] args) {

		String[] name = new String[10];
		//int kor[] = new int[10]; //이것도 가능
		int[] kor = new int[10];
		int[] eng = new int[10];
		int[] mat = new int[10];
		int[] tot = new int[10];
		float[] avg = new float[10];
		
		name[0] = "홍길동";
		kor[0] = 100;
		eng[0] = 90;
		mat[0] = 100;
		tot[0] = kor[0]+eng[0]+mat[0];
		avg[0] = tot[0]/3.0f;
		
		System.out.println(name[0]+"님의 평균 점수는 "+avg[0]);
	}

	public static void main01(String[] args) {
		int kor,eng,mat,soc,sci,tot;
		float avg;
		
		kor = 108;
		eng = 90;
		mat = 90;
		soc = 100;
		sci = 100;
		
		tot = kor+eng+mat+soc+sci;
		avg = tot/5.0f;
		System.out.println(avg);
	}

}
