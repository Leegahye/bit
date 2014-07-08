package servlets.step04HW;

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

@WebServlet("/score/step04HW/list")
public class PersonList extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	  
    try {
      ServletContext ctx = this.getServletContext();
      PersonDao personDao = (PersonDao)ctx.getAttribute("personDao");
      ArrayList<Person> persons = personDao.list();
      
      response.setContentType("text/html; charset=UTF-8");
      RequestDispatcher rd = request.getRequestDispatcher("/score/step04HW/PersonList.jsp");
      request.setAttribute("persons", persons);
      rd.include(request, response);
    
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/score/step04HW/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }    
  }
}
