package exam.oop.instance.ex;

public class Calculator02 {
	
	static int result;
	
	public static void init(int value){
		Calculator02.result = value;
	}
	public static void plus(int value){
		Calculator02.result += value;
	}
	public static void minu(int value){
		Calculator02.result -= value;
	}
	public static void mult(int value){
		Calculator02.result *= value;
	}
	public static void divi(int value){
		Calculator02.result /= value;
	}

}
