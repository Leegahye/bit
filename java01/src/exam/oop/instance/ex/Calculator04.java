package exam.oop.instance.ex;

public class Calculator04 {
	int result;
	
	public void init(int value){
		this.result = value;
	}
	public void plus(int value){
		this.result += value;
	}
	public void minu(int value){
		this.result -= value;
	}

	public void mult(int value){
		this.result *= value;
	}

	public void divi(int value){
		this.result /= value;
	}
}
