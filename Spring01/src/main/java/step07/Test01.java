package step07;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
            new String[]{"step04/application-context4.xml"});
    
    Car c1 = (Car)ctx.getBean("c1"); 
    Map<String, Object> opt = c1.getOptions();
    System.out.println(opt);
    
  }
}


