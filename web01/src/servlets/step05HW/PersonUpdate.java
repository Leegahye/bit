package servlets.step05HW;

import java.util.Map;

public class PersonUpdate implements PageController {
 
	PersonDao personDao;
	
	public void setPersonDao(PersonDao personDao){
		this.personDao=personDao;
	}
	@Override
	public String execute(Map<String, String[]> params, Map<String, Object> model)
			throws Exception {
    int no = Integer.parseInt(params.get("mno")[0]);
    
    if(params.get("name") == null){
    	model.put("person", personDao.selectOne(Integer.parseInt(params.get("no")[0])));
    	return "/score/step05HW/personupdateform.jsp";
    }else{
    	Person person = new Person();
	    person.setNo(Integer.parseInt(params.get("mno")[0]));
	    person.setName(params.get("name")[0]);
	    person.setEmail(params.get("email")[0]);
	    person.setTel(params.get("tel")[0]);
	    person.setPw(params.get("pwd")[0]);
	    
	    return "redirect:list.do";
    }
  }
}














