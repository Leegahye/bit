package exam.basic;

import java.util.Scanner;

public class Control01_t01 {

	public static void main(String[] args) {
		//문제4)단, switch 연산자
		//다음과 같이 동작하도록 코드를 구현하세요.
		//첫번째수를 입력하세요. 10
		//연산자를 입력하세요? +,-,*,/
		//2번째 수를 입력하세요? 3
		//계산결과는 5 입니다.
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 수를 입력 : ");
		String text = sc.nextLine();
		int num1 = Integer.parseInt(text);
		System.out.print("연산자를 입력 : " );
		String x = sc.nextLine();
		System.out.print("두 번째 수를 입력 : " );
		text = sc.nextLine();
		int num2 = Integer.parseInt(text);
		int result;
		switch(x){
		case "+":
			result = num1+num2;
			break;
		case "-":
			result = num1-num2;
			break;
		case "*":
			result = num1*num2;
			break;
		case "/":
			result = num1/num2;
			break;
		default:
			System.out.println("잘못입력하셨습니다.");
			return;
		}
		System.out.println("계산결과는 "+result+"입니다.");
	}
	
	public static void main01(String[] args) {
		/*System.out.print("당신의 나이는? ");
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		int age = Integer.parseInt(text);
		System.out.println(age+"살 입니다.");*/
		
		//문제1)
		//7세이하는 "유아입니다"
		//8세이상~18세 미만 "청소년 입니다"
		//18세이상~30세 미만 "청년입니다"
		//30세 이상~50세미만 "장년입니다"
		//50세 이상~ 60세미만 "중년입니다"
		//그 밖에"노인입니다.
		
		System.out.print("나이를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int age = Integer.parseInt(s);
		
		if(age <= 7){
			
			System.out.println("유아입니다.");
		}else if(age >= 8 && age < 18){
			System.out.println("청소년 입니다.");
		}else if(age >= 18 && age <30){
			System.out.println("청년입니다.");
		}else if(age >= 30 && age <50){
			System.out.println("장년입니다.");
		}else if(age >= 50 && age <60){
			System.out.println("중년입니다.");
		}else
			System.out.println("노인입니다.");

	}
	
	public static void main02(String[] args) {
		//문제2)
		//다음과 같이 동작하도록 코드를 구현하세요.
		//첫번째수를 입력하세요. 10
		//연산자를 입력하세요? +(0),-(1),*(2),/(3) 3
		//2번째 수를 입력하세요? 3
		//계산결과는 5 입니다.
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 수를 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("연산자를 입력 +(0),-(1),*(2),/(3) : " );
		int x = sc.nextInt();
		System.out.print("두 번째 수를 입력 : " );
		int num2 = sc.nextInt();
		int result;
		if(x == 0){
			result = num1+num2;
		}else if(x == 1){
			result = num1-num2;
		}else if(x == 2){
			result = num1*num2;
		}else if(x == 3){
			result = num1/num2;
		}else {
			System.out.println("잘못입력하셨습니다.");
			return;
		}
		System.out.println("계산결과는 "+result+"입니다.");
	}
	
	public static void main03(String[] args) {
		//문제3)단, switch 연산자
		//다음과 같이 동작하도록 코드를 구현하세요.
		//첫번째수를 입력하세요. 10
		//연산자를 입력하세요? +(0),-(1),*(2),/(3) 3
		//2번째 수를 입력하세요? 3
		//계산결과는 5 입니다.
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 수를 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("연산자를 입력 +(0),-(1),*(2),/(3) : " );
		int x = sc.nextInt();
		System.out.print("두 번째 수를 입력 : " );
		int num2 = sc.nextInt();
		int result;
		switch(x){
		case 0:
			result = num1+num2;
			break;
		case 1:
			result = num1-num2;
			break;
		case 2:
			result = num1*num2;
			break;
		case 3:
			result = num1/num2;
			break;
		default:
			System.out.println("잘못입력하셨습니다.");
			return;
		}
		System.out.println("계산결과는 "+result+"입니다.");
	}
	
	

}
