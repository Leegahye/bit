package exam.oop.instance.ex;

public class Calculator03 {
	int result;
	
	public static void puls(Calculator03 that, int value){
		that.result += value;
	}
	public static void minu(Calculator03 that, int value){
		that.result -= value;
	}
	public static void mult(Calculator03 that, int value){
		that.result *= value;
	}
	public static void divi(Calculator03 that, int value){
		that.result /= value;
	}
	public static void init(Calculator03 that, int value) {
		that.result = value;
	  
  }

}
