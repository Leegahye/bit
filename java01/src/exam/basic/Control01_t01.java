package exam.basic;

import java.util.Scanner;

public class Control01_t01 {

	public static void main(String[] args) {
		System.out.print("당신의 나이는? ");
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		int age = Integer.parseInt(text);
		System.out.println(age+"살 입니다.");

	}

}
