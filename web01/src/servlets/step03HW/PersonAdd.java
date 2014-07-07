package servlets.step03HW;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/score/step03HW/add")
public class PersonAdd extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 필터로 대체함
    //request.setCharacterEncoding("UTF-8");
    
    Person person = new Person();
    person.setName(request.getParameter("name"));
    person.setEmail(request.getParameter("email"));
    person.setTel(request.getParameter("tel"));
    person.setPw(request.getParameter("pw"));
    
    ServletContext ctx = this.getServletContext();
    PersonDao scoreDao = (PersonDao)ctx.getAttribute("personDao");
    
    try {
      scoreDao.insert(person);
      
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset=\"UTF-8\">");
      out.println("<meta http-equiv='Refresh' content='1; url=list'>");
      out.println("<title>회원 등록</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<p>등록 성공입니다.</p>");
      
      RequestDispatcher rd = request.getRequestDispatcher("/score/step03HW/copyright");
      rd.include(request, response);
      
      out.println("</body>");
      out.println("</html>");
      
    } catch (Exception e) {
      // 오류가 발생하면 /score/step03/error 서블릿으로 위임한다.
      // 요청 배달자를 통해 요청을 해당 서블릿으로 배달한다.
      RequestDispatcher rd = request.getRequestDispatcher("/score/step03HW/error");
      
      // ErrorServlet에 실행을 위임하기 전에 ServletRequest 보관함에 
      // 오류정보를 담아서 보낸다.
      request.setAttribute("error", e);
      
      rd.forward(request, response);
    }
  }
}














