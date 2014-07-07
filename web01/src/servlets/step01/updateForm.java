package servlets.step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/score/updateform")
public class updateForm extends HttpServlet{
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
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {


	    // 출력되는 내용을 지정된 문자집합으로 인코딩한다.
	    // 인코딩 => 문자집합 명세서에 나와 있는대로 각 문자에 대해 코드 값으로 바꾼다.
	    // 'A' -> 0x41(1byte), '가' => 0x80xxxx (3byte)
	    response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    int no = Integer.parseInt(request.getParameter("no"));


	    try {
	    		Score score = scoreDao.getNumber(no);

			 	out.println("<!DOCTYPE html>");
			    out.println("<html>");
			    out.println("<head>");
			    out.println("<meta charset=\"UTF-8\">");
			    out.println(" <title>성적 변경</title>");
			    out.println("</head>");
			    out.println("<body>");
			    out.println("<form action=\"update\" method = \"post\">");
			    out.println("<h1>성적 변경</h1>");
			    out.println("<input type=\"hidden\" name=\"sno\" value=\""+ score.getNo()+"\"><br>");
			    out.println("이름 <input type=\"text\" name=\"name\" value=\""+ score.getName()+"\"><br> ");
			    out.println("국어 <input type=\"text\" name=\"kor\" value=\""+ score.getKor() +"\"><br>");
			    out.println("영어 <input type=\"text\" name=\"eng\" value=\""+ score.getEng() +"\"><br>");
			    out.println("수학 <input type=\"text\" name=\"math\" value=\""+ score.getMath() +"\"><br>");
			    out.println("  <td><input type=\"submit\" value=\"변경\"></td>");

		} catch (Exception e) {
			 e.printStackTrace();
		}
	    out.println(" </body>");
	    out.println("</html>");
	  }

	  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		  doGet(req, resp);
	  }
}