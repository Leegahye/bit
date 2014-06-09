package exam.oop.instance.ex;

import exam.oop.instance.Calculator02;

public class CalcTest04 {

	public static void main(String[] args) {
		
		Calculator04 calc1 = new Calculator04();
		Calculator04 calc2 = new Calculator04();
		
		calc1.init(5);
		calc2.init(6);
		
		calc1.plus(3);
		calc2.minu(2);
		
		
		calc1.mult(7);
		calc2.plus(3);
		System.out.println(calc1.result);
		System.out.println(calc2.result);
		
	}

}
