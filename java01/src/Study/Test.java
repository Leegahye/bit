package Study;
class A{
	   int num = 7;
	   void m1(){
	     System.out.println("A's m1, ");
	   }
	   void m2(){
	     System.out.println("A's m2, ");
	}
}
	class B extends A{
	   void m1(){
	     System.out.println("B's m1, ");
	   }
	}
	class C extends B{
	   void m3(){
	     System.out.println("C's m3, "+ (num + 6));
	   }
	}
	public class Test{
		public static void main(String[] args){

			A a = new A();
	   		B b = new B();
	    	C c = new C();
	  		
	    	c.m1();
	    	  c.m2();
	    	  a.m2();
	    	  
		}
	}


    