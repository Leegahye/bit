package servlets.step05HW;

import java.util.Map;

public class PersonDelete  implements PageController {
  
	PersonDao personDao;
	
	public void setPersonDao(PersonDao personDao){
		this.personDao = personDao;
	}
	
	@Override
	public String execute(Map<String, String[]> params,
			Map<String, Object> model) throws Exception {

    int no = Integer.parseInt(params.get("no")[0]);
    
      personDao.delete(no);
      
      return "redirect:list.do";
  }

}














