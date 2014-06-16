package Study;

class A{
	 private int a = 10;
	 int b = 20;    //default
	 protected int c = 30;
	 public int d = 40;
	 public int getA(){  //private 변수를 사용하기 위한 변수
		 return a;
	 }
	}
	class Test {
		 private int a = 1;
		 int b = 2;
		 protected int c = 3;
		 public int d = 4;

	 public static void main(String[] args)  {
	  A a = new A();
	  Test t = new Test();
	  
	  System.out.println("private : " + a.getA());
	  System.out.println("default : " + a.b); 
	  System.out.println("private : " + t.a);
	  System.out.println("protected : " + t.c);
	 }
	}

    