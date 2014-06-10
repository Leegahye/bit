package Study;

class Calculator000 {
	
	int result;
	
	public void init(int value){
		this.result = value;
	}
	public void plus(int value){
		this.result += value;
	}
	public void minus(int value){
		this.result -= value;
	}
	public void multiple(int value){
		this.result *= value;
	}
	public void divide(int value){
		this.result /= value;
	}
}

public class exam_01 {

	public static void main(String[] args) {
  
		Calculator000 calc1 = new Calculator000();
		Calculator000 calc2 = new Calculator000();
		
		calc1.init(5);
		calc2.init(6);
		
		calc1.plus(3);
		calc2.minus(2);
		
		calc1.multiple(7);
		calc2.plus(3);
		System.out.println(calc1.result + calc2.result);
	
	}

}