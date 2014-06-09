package exam.oop.instance.ex;

public class CalcTest03 {

	public static void main(String[] args) {
		Calculator03 calc1 = new Calculator03();
		Calculator03 calc2 = new Calculator03();
		
		Calculator03.init(calc1, 5);
		Calculator03.init(calc2,6);
		
		Calculator03.puls(calc1, 3);
		Calculator03.minu(calc2, 2);		
		
		Calculator03.mult(calc1,7);
		Calculator03.puls(calc2, 3);
		System.out.println(calc1.result);
		System.out.println(calc2.result);
		
	}

}
