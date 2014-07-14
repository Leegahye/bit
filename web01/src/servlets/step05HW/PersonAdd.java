package servlets.step05HW;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/score/step04HW/add")
public class PersonAdd implements PageController {
 
	PersonDao personDao;
	
	public void setPersonDao(PersonDao personDao){
		this.personDao = personDao;
	}
	@Override
	public String execute(Map<String, String[]> params,
			Map<String, Object> model) throws Exception {
		
    Person person = new Person();
    person.setName(params.get("name")[0]);
    person.setEmail(params.get("email")[0]);
    person.setTel(params.get("tel")[0]);
    person.setPw(params.get("pwd")[0]);

     personDao.insert(person);
     
     return "redirect:list.do";
	
  }
}














