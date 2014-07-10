package servlets.step05HW;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//ServletContextEvent 를 처리하는 역할
// - 웹 애플리케이션을 시작하거나 종료할 때 발생되는 이벤트
// - 웹 애플리케이션이 시작될 때 초기 작업을 수행
// - 웹 애플리케이션이 종료될 때 마무리 작업 수행
//web.xml에 리스너를 배치해야 동작한다.
// - web.xml참조
public class ContextLoaderListener implements ServletContextListener{

	//웹 애플리케이션이 시작될 때 호출된다.
	// => 웹 애플리케이션을 위한 공용 자원을 준비한다.
	@Override
	public void contextInitialized(ServletContextEvent event) {
	  try {
		  ServletContext ctx = event.getServletContext();
	      DbConnectionPool dbConnectionPool = new DbConnectionPool(
    		  ctx.getInitParameter("driver"),
    		  ctx.getInitParameter("url"),
    		  ctx.getInitParameter("username"),
    		  ctx.getInitParameter("password"));
	      
	      PersonDao personDao = new PersonDao();
	      personDao.setDbConnectionPool(dbConnectionPool);
	      
	      ctx.setAttribute("dbConnectionPool", dbConnectionPool);
	      ctx.setAttribute("personDao", personDao);
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	    }	
	}
	@Override
	public void contextDestroyed(ServletContextEvent event) {
	  ServletContext ctx = event.getServletContext();
	    DbConnectionPool dbConnectionPool = 
	        (DbConnectionPool)ctx.getAttribute("dbConnectionPool");
	    dbConnectionPool.closeAll();
	}
}
