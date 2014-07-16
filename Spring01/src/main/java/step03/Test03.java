package step03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
	  public static void main(String[] args) {
		    ApplicationContext ctx = new ClassPathXmlApplicationContext(
		            new String[]{"step03/application-context3.xml"});
		    
		Car c1 = (Car)ctx.getBean("c1");
		Car c2 = (Car)ctx.getBean("c2");
		
		// scope이 prototype인 경우, getBean() 호출 때마다 생성된다.
		// 따라서 다음 조건은 거짓이다.
		if(c1.getEngine() == c2.getEngine()) 
			System.out.println("e1 == c1.getEngine()");
		
	}
}
