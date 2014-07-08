package servlets.step04HW;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/score/step04HW/update")
public class PersonUpdate extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("mno"));
    
    try {
      ServletContext ctx = this.getServletContext();
      PersonDao personDao = (PersonDao)ctx.getAttribute("personDao");
      Person person = personDao.selectOne(no);
      
      response.setContentType("text/html; charset=UTF-8");
      
      RequestDispatcher rd = request.getRequestDispatcher("/score/step04HW/personupdateform.jsp");
      request.setAttribute("person", person);
      rd.include(request, response);
      
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/score/step04HW/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
   
    Person person = new Person();
    person.setNo(Integer.parseInt(request.getParameter("mno")));
    person.setName(request.getParameter("name"));
    person.setEmail(request.getParameter("email"));
    person.setTel(request.getParameter("tel"));
    person.setPw(request.getParameter("pwd"));
    
    ServletContext ctx = this.getServletContext();
    PersonDao personDao = (PersonDao)ctx.getAttribute("personDao");
    
    try {
      personDao.update(person);
      response.sendRedirect("list");
      
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/score/step04HW/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
  }
}














