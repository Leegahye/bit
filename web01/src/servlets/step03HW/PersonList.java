package servlets.step03HW;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/score/step03HW/list")
public class PersonList extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>회원 관리</title>");
    out.println("<style type=\"text/css\">");
    out.println("table {");
    out.println("  font-family: verdana,arial,sans-serif;");
    out.println("  font-size:11px;");
    out.println("  color:#333333;");
    out.println("  border-width: 1px;");
    out.println("  border-color: #666666;");
    out.println("  border-collapse: collapse;");
    out.println("}");
    out.println("table th {");
    out.println("  border-width: 1px;");
    out.println("  padding: 8px;");
    out.println("  border-style: solid;");
    out.println("  border-color: #666666;");
    out.println("  background-color: #dedede;");
    out.println("}");
    out.println("table td {");
    out.println("  border-width: 1px;");
    out.println("  padding: 8px;");
    out.println("  border-style: solid;");
    out.println("  border-color: #666666;");
    out.println("  background-color: #ffffff;");
    out.println("}");
    out.println("</style>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 관리</h1>");
    out.println("<a href='personform.html'>추가</a>");
    out.println("<table>");
    out.println("<tr>");
    out.println("  <th>번호</th> ");
    out.println("  <th>이름</th> ");
    out.println("  <th>이메일</th> ");
    out.println("  <th>전화번호</th> ");
    out.println("  <th></th>");
    out.println("</tr>");

    try {
      ServletContext ctx = this.getServletContext();
      PersonDao personDao = (PersonDao)ctx.getAttribute("personDao");
      ArrayList<Person> persons = personDao.list();
      for (Person person : persons) {
    	  
        out.println("<tr>");
        // format()과 동일한 기능을 수행하는 printf()도 있다는 것을 보여주기 위해 사용!
        out.printf("  <td>%1$d</td> ", person.getNo());
        out.format("  <td><a href='update?mno=%1$d'>%2$s</a></td> ", person.getNo(), person.getName());
        out.format("  <td>%1$s</td> ", person.getEmail());
        out.format("  <td>%1$s</td> ", person.getTel());
        out.format("  <td><a href='delete?no=%1$d'>삭제</a></td>", person.getNo());
        out.println("</tr>");
      }
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/score/step03HW/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
    
    out.println("</table>");
    
    RequestDispatcher rd = request.getRequestDispatcher("/score/step03HW/copyright");
    rd.include(request, response);
    
    out.println("</body>");
    out.println("</html>");
  }

}
