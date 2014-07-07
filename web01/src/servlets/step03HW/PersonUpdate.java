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

@WebServlet("/score/step03HW/update")
public class PersonUpdate extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("no"));
    
    try {
      ServletContext ctx = this.getServletContext();
      PersonDao personDao = (PersonDao)ctx.getAttribute("personDao");
      Person person = personDao.selectOne(no);
      
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset=\"UTF-8\">");
      out.println("<title>회원 변경폼</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>회원 변경</h1>");
      out.println("<form action=\"update\" method=\"post\">");
      out.format("번호: <input type=\"text\" name=\"no\" value='%1$s' readonly><br>", 
          person.getNo());
      out.format("이름: <input type=\"text\" name=\"name\" value='%1$s'><br>", 
    		  person.getName());
      out.format("이메일: <input type=\"text\" name=\"email\" value='%1$s'><br>",
    		  person.getEmail());
      out.format("전화번호: <input type=\"text\" name=\"tel\" value='%1$s'><br>",
    		  person.getTel());
      out.format("암호 : <input type=\"text\" name=\"pwd\" value='%1$s'><br>",
    		  person.getPw());
      out.println("<input type=\"submit\" value=\"변경\">");
      out.println("</form>");
      
      RequestDispatcher rd = request.getRequestDispatcher("/score/step03HW/copyright");
      rd.include(request, response);
      
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/score/step03HW/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
    
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 필터로 대체함
    //request.setCharacterEncoding("UTF-8");
    
    Person person = new Person();
    person.setNo(Integer.parseInt(request.getParameter("no")));
    person.setName(request.getParameter("name"));
    person.setEmail(request.getParameter("email"));
    person.setTel(request.getParameter("tel"));
    person.setPw(request.getParameter("pwd"));
    
    ServletContext ctx = this.getServletContext();
    PersonDao personDao = (PersonDao)ctx.getAttribute("personDao");
    
    try {
      personDao.update(person);
      
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset=\"UTF-8\">");
      out.println("<meta http-equiv='Refresh' content='1; url=list'>");
      out.println("<title>회원정보 변경</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<p>변경 성공입니다.</p>");
      
      RequestDispatcher rd = request.getRequestDispatcher("/score/step03HW/copyright");
      rd.include(request, response);
      
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/score/step03HW/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
  }
}














