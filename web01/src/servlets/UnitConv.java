package servlets;
/*
 * 목표 : 웹 브라우저가 보낸 데이터 읽기
 *  1) 한글 오류 처리
 *   - 웹 브라우저가 보낸 문자열을 ISO-8859-1로 취급한다.
 *   - 각 바이트에 무식하게 그냥 00을 붙여서 유니코드로 만든다.
 *   - 영어가 아닌 글자는 잘못된 유니코드로 바뀌기 때문에 글자가 깨지게 된다.
 *   
 *   -> 해결책 : 값을 꺼내기 전(getParameter() 호출 전)에 문자열의 characterset을 알려준다.
 *      GET => 서블릿 컨테이너의 메뉴얼에 따라 처리하라!
 *      POST => request.setCharacterEncoding("UTF-8") 호출한다.
 * 
 * 	2)POST명령 처리 (doPost 재정의)
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UnitConv")
public class UnitConv extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int num = Integer.parseInt(request.getParameter("num"));
		String unit1 = request.getParameter("unit1");
		String unit2 = request.getParameter("unit2");
	
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>단위환산 프로그램</h1>");
		out.println("<form action=\"../UnitConv\" method=\"post\">");
		out.println("<input type=\"text\" name=\"num\">");
		out.println("<select name=\"unit1\">");
		out.println("<option>cm</option>");
		out.println("<option>inch</option>");
		out.println("<option>yd</option>");
		out.println("<option>km</option>");
		out.println("</select>");
		out.println("<select name=\"unit2\">");
		out.println("<option>cm</option>");
		out.println("<option>inch</option>");
		out.println("<option>yd</option>");
		out.println("<option>km</option>");
		out.println("</select>");
		out.println("<input type=\"submit\" value=\"변환\">");
		out.println("</form></body></html>");		

		out.println(conv(num, unit1, unit2) + " "+unit2+ " 입니다");
		
	}
	private double conv(float num, String unit1, String unit2){
		double result = 0;
		if(unit1.equals("cm")){
			if(unit2.equals("inch")){
				result = num*0.393701;
			}else if(unit2.equals("yd")){
				result = num*0.010936;
			}else if(unit2.equals("km")){
				result = num*0.00001;
			}else if(unit2.equals("cm")){
				result = num;
			}
		}else if(unit1.equals("inch")){
			if(unit2.equals("inch")){
				result = num;
			}else if(unit2.equals("yd")){
				result = num*0.027778;
			}else if(unit2.equals("km")){
				result = num*0.000025;
			}else if(unit2.equals("cm")){
				result = num*2.54;
			}
		}else if(unit1.equals("yd")){
			if(unit2.equals("inch")){
				result = num*36;
			}else if(unit2.equals("yd")){
				result = num;
			}else if(unit2.equals("km")){
				result = num*0.00914;
			}else if(unit2.equals("cm")){
				result = num*91.44;
			}
		}else if(unit1.equals("km")){
			if(unit2.equals("inch")){
				result = num*39370.0787;
			}else if(unit2.equals("yd")){
				result = num*1093.6133;
			}else if(unit2.equals("km")){
				result = num;
			}else if(unit2.equals("cm")){
				result = num*100000;
			}
		}
		
		return result;
	}
	
}
