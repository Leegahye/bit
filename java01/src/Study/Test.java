package Study;

/*class Test{ 
	 int a=10; 
	class Joo{ 
	int b=20; 
	public void joo(){ 
		System.out.println("Joo 클래스가 InstanceClass 입니다."); 
	} 
} 
	public static void main(String[] args){
	 Test t=new Test(); 
	 Test.Joo j=t.new Joo(); 
	 j.joo(); 
	} 
} 
*/
interface A{
	int num = 20;
	public void m();
}
class Test{   
	public static void main(String[] args) {
		A a = new A(){
			public void m(){
				System.out.println("aa");
			}
		};
		a.m();
	}
}