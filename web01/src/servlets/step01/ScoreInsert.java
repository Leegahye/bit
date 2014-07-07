package servlets.step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/score/insert")
public class ScoreInsert  extends HttpServlet {
  private static final long serialVersionUID = 1L;
  DbConnectionPool dbConnectionPool;
  ScoreDao scoreDao;
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    
    try {
      dbConnectionPool = new DbConnectionPool(
          "com.mysql.jdbc.Driver",
          "jdbc:mysql://localhost:3306/bitdb?useUnicode=true&characterEncoding=UTF-8",
          "bit", "1111");
      scoreDao = new ScoreDao();
      scoreDao.setDbConnectionPool(dbConnectionPool);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void destroy() {
    super.destroy();
    
    dbConnectionPool.closeAll();
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
	 try {          	
		  Score score = new Score();
	      response.setContentType("text/html; charset=UTF-8");
		  PrintWriter out = response.getWriter();
		   
		  String name = request.getParameter("name");
		  int kor = Integer.parseInt(request.getParameter("kor"));
		  int eng = Integer.parseInt(request.getParameter("eng"));
		  int math = Integer.parseInt(request.getParameter("math"));
			
		  score.setName(name);
		  score.setKor(kor);
		  score.setEng(eng);
	      score.setMath(math);
		
		  scoreDao.insert(score);

	      out.println("<!DOCTYPE html>");
	      out.println("<html>");
	      out.println("<head>");
	      out.println("<meta charset=\"UTF-8\">");
	      out.println("<meta http-equiv='Refresh' content='1; url=list'>");
	      out.println("<title>성적 추가</title>");
	      out.println("</head>");
	      out.println("<body>");
	      out.println("<p>추가 성공입니다.</p>");
	      out.println("</body>");
	      out.println("</html>");
	    } catch (Exception e) {
	    	e.printStackTrace(); 
	    }
	}
}
