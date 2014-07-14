package servlets.step05HW;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PersonList implements PageController {
	PersonDao personDao;
	
	public void setPersonDao(PersonDao personDao){
		this.personDao = personDao;
	}
		
	@Override
	public String execute(Map<String, String[]> params,
			Map<String, Object> model) throws Exception {

     model.put("persons", personDao.list());
     return "/score/step05HW/PersonList.jsp";
  }
}
