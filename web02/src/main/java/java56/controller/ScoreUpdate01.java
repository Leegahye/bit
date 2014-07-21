package java56.controller;

import java.text.SimpleDateFormat;
import java.util.Map;

import java56.dao.ScoreDao;
import java56.vo.Score;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
@RequestMapping("/score/step01/update")
public class ScoreUpdate01{
	static Logger logger = Logger.getLogger(ScoreUpdate01.class);
  @Autowired
  ScoreDao scoreDao;
  
  @RequestMapping(method=RequestMethod.GET)
  public String detail(int no, Map<String, Object> model)
      throws Exception {
      model.put("score", scoreDao.selectOne(no));
      return "/score/step01/scoreupdateform.jsp";   
    }
  
  @RequestMapping(method=RequestMethod.POST)
  public String update(Score score, Map<String, Object> model)
      throws Exception {
	  scoreDao.update(score);
      return "redirect:list.do";
  }
  
  @InitBinder
  public void initBinder(WebDataBinder binder){
	  //프런트 컨트롤러가 이 메서드를 호출할 때 커스텀 에디터를 등록할 수 있도록 WebDataBinder를 준다.
	  //우리는 이 객체를 사용하여 커스텀 에디터를 등록할 것이다.
	  logger.debug("ScoreUpdate 의 initBinder()호출됨");
	  //문자열을 java.util.Date 객체로 바꿔주는 커스텀 에디터를 스프링에서 제공한다. 그것을 사용.
	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	  CustomDateEditor customEditor = new CustomDateEditor(
			  dateFormat, /*요청정보의 문자열의 형식 지정*/
			  true /*빈 문자열 허용 여부*/
			  );
	  binder.registerCustomEditor(
			  java.util.Date.class, /*문자열을 어떤 타입의 값으로 바꿀지 지정한다.*/ 
			  customEditor /*커스텀 에디터 객체를 지정한다.*/
			  );
  }
}
