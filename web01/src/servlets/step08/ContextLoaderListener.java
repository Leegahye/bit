package servlets.step08;

import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

// => DAO 및 SqlSessionFactory 객체도 ServletContext에 보관한다.
// => setter 메서드를 찾아서 호출한다.
public class ContextLoaderListener implements ServletContextListener {
  static Logger logger = Logger.getLogger(ContextLoaderListener.class);
  ServletContext ctx;
  
  @Override
  public void contextInitialized(ServletContextEvent event) {
    logger.debug("contextInitialized 호출됨...");
    try {
      ctx = event.getServletContext(); //ServletContext보관소 주소를 불러와서 저장한다.
      
      prepareMyBatis();//MyBatis sqlSessionFactory 객체 준비
     
      String[] classnames = getClassNamesFromPackage(); //패키지로부터 클래스이름 가져오기
      
      prepareObjectsForClassWithComponentAnnotation(classnames);//컴포넌트 애노테이션이 붙은 객체 준비하기(인스턴스생성)
      
      prepareDependancies();//생성된 인스턴스들의 의존객체를 setter메소드를 통해 주입한다.

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
	
	private void prepareMyBatis() throws Exception {
		String resource = "servlets/step08/mybatis-config.xml";
	     
		//SqlSessionFactory 객체를 만들어서 servletContext에 보관한다.
	      InputStream inputStream = Resources.getResourceAsStream(resource);
	      SqlSessionFactory sqlSessionFactory = 
	          new SqlSessionFactoryBuilder().build(inputStream);
	      ctx.setAttribute("sqlSessionFactory", sqlSessionFactory);
	}

	private String[] getClassNamesFromPackage() throws Exception{
		logger.debug(ctx.getRealPath("/WEB-INF/classes/servlets/step08"));
	    File classDir = new File(ctx.getRealPath("/WEB-INF/classes/servlets/step08"));
	      
	    //list-> 모든 파일중 .class 인 파일만 리턴
		return classDir.list(new FilenameFilter() { //익명이너클래스
			@Override
			public boolean accept(File dir, String name) {
				if(name.endsWith(".class")){
					return true;
				}else return false;
			}
	   });
	}
		
	//추출한 .class 파일에서 Component가 붙은 클래스에 대해서만 인스턴스 준비
	private void  prepareObjectsForClassWithComponentAnnotation(String[] classnames) throws Exception{
		Class<?> clazz = null;
		Object instance = null;
		Component compAnno = null;
		
		 for(String classname : classnames){
    	   clazz = loadClass(classname);
    	   compAnno = getComponentAnnotation(clazz);//컴포넌트 애노테이션 추출
    	   if(compAnno != null){    		   
    		   instance = createInstance(clazz); //인스턴스 생성
    		   ctx.setAttribute(compAnno.value(), instance);//애노테이션으로부터 값을 꺼내서 =>ServletContext에 컴포넌트이름(compAnno), 인스턴스주소(value()) 를 보관소에 저장
    	   }    	  
		 }
	}
	
	private void prepareDependancies() throws Exception{
		 Enumeration<String> instanceNames = ctx.getAttributeNames();
		  Object instance = null;
			
		  String instanceName = null;
		  while(instanceNames.hasMoreElements()){
			  instanceName = instanceNames.nextElement();
			  instance = ctx.getAttribute(instanceName);
		 
			  injectDependancy(instance);
		  }
	}
	
  	private void injectDependancy(Object instance) throws Exception{
  		//메서드 목록 가져오기.
  		Method[] methods = instance.getClass().getMethods();
  		Object dependancy = null;
  		for(Method method : methods){
  			if(method.getName().startsWith("set") 
  					&& method.getParameterCount() == 1){//메서드가 setter메서드인 경우
  				logger.debug(instance.getClass().getSimpleName() + " : " + method.getName());
  				dependancy = findDependancyFromServletContext(
  						method.getParameters()[0].getType()/*파라미터타입과 일치하는 객체 찾기*/);
  				if(dependancy != null){ //setter 메서드의 의존객체를 찾았다면, setter 호출!
  					logger.debug(method.getName() + " 호출");
  					method.invoke(instance, dependancy); //(인스턴스주소,파라미터객체)주입
  				}
  			}
  		}
  	}
  	
  	private Object findDependancyFromServletContext(Class<?> clazz){
  		logger.debug("파라미터 찾기 => " + clazz.getSimpleName() + " 타입의 인스턴스 찾기");
  		Enumeration<String> instanceNames = ctx.getAttributeNames();
  		Object instance = null;
  		
  		String instanceName = null;
  		while(instanceNames.hasMoreElements()){
  			instanceName = instanceNames.nextElement();
  			instance = ctx.getAttribute(instanceName);
  			if(instance != null && clazz.isInstance(instance)){
  				return instance;
  			}
  		}
  		return null;
  	}
  	
	private Object createInstance(Class<?> clazz) throws InstantiationException,
			IllegalAccessException {
		Object instance;
		instance = clazz.newInstance();
		  logger.debug("      " + clazz.getSimpleName() + " 인스턴스 생성됨");
		  return instance;
	}

	private Component getComponentAnnotation(Class<?> clazz) {
		return (Component)clazz.getAnnotation(Component.class);
	}
	
	private Class<?> loadClass(String classname) throws ClassNotFoundException {
		Class<?> clazz = Class.forName("servlets.step08." + 
				  classname.substring(0,classname.indexOf('.')));
		  logger.debug("==>" + clazz.getName());
		return clazz;
	}
	  
    @Override
    public void contextDestroyed(ServletContextEvent event) {
      logger.debug("contextDestroyed 호출됨...");
    }
}