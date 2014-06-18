package Study;

import java.util.ArrayList;
import java.util.List;

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
class Test{   
	public static void main(String[] args) {
		  List testList = new ArrayList();       // 디폴트 사이즈는 10이다
           //List testList1 = new ArrayList(5);     // 5로 사이즈 지정 


           List list = new ArrayList();
           list.add("good");
           list.add( new Integer(100) );
           list.add( new Float(40.4F));      // 이런 방식으로 리스트를 생성하고 데이터를  삽입한다.

           System.out.println(list);  // good, 100, 40.4 가 출력된다.
	}
}