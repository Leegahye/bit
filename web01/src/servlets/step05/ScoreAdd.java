package servlets.step05;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScoreAdd implements PageController {
	ScoreDao scoreDao;
	
	public void setScoreDao(ScoreDao scoreDao){
		this.scoreDao = scoreDao;
	}
	
	@Override
	public String execute(Map<String, String[]> params, Map<String, Object> model)
			throws Exception {
 
    Score score = new Score();
    score.setName(params.get("name")[0]);
    score.setKor(Integer.parseInt(params.get("kor")[0]));
    score.setEng(Integer.parseInt(params.get("eng")[0]));
    score.setMath(Integer.parseInt(params.get("math")[0]));

    scoreDao.insert(score);
    return "redirect:list.do"; 
  }
}














