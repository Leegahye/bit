package Study;

public class Person {
	
/*//필드 : 값을 저장할 멤버변수 선언.
	public String name;
	public int age;
	
	//생성자
	//클래스이름과 동일한 메소드, 이 클래스의 객체가 생성될 때만 자동으로 호출되는 메소드.
	//초기화를 수행하는 코드를 포함.
	//오버로딩이 가능하다.(여러개의 생성자를 만들 수 있음)
	//리턴타입이 없다.
	//-> 일반메소드가 아무값을 리턴하지않을때 void를 리턴타입으로 지정하는것과는 달리
	//   생성자는 필드를 초기화하거나 객체가 처음 생성되는 순간에 처리할 작업을 수행한다.
	
	public Person(String name){
		this.name = name;		
	}
	public Person(String name, int age){
		
	}
 public Person(String n, int a,int i){
		
	}
	
	public String getName(){
		return name;
	}
	
	public static void main(String[] args){
		
		Person[] p;//배열에 대한 레퍼런스 선언.
		p = new Person[10];//Person객체에 대한 레퍼런스가 10개 생성된다.
		
	 Person p = new Person("홍길동");
		for(int i=0; i<p.length; i++){
			p[i] = new Person();//Person() 객체를 생성하고
			p[i].age = 30+i;//Person객체의 age멤버값을 30+i로 설정한다.
		}
		for(int i=0; i<p.length; i++){
			System.out.print(p[i].age+" ");
		}
	}*/

  /*public static void main(String[] args) {
		//레퍼런스변수 선언
		//->Person타입의객체에 대한 p 라는 레퍼런스 변수의 선언일 뿐 객체가 생성되는것은 아님.
		Person p; 
		p = new Person("홍길동");//객체를 생성후 Person객체에 대한 레퍼런스 값을 p변수에 대입.
		//
		p.age = 30;
		String s =p.getName();
	}
	*/
	
	public Person(){
		System.out.println("생성자가 호출되었습니다.");
		Print();
	}
	public void Print(){
		System.out.println("Print");
	}
	
	public static void main(String[] args) {
	  new Person();
  }


}
