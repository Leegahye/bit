<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL선언</title>
</head>
<body>
<h1>EL 선언</h1>
<%--  JSP액션태그 : JSP에서 기본으로 제공하는 특별한 태그
      => 특정 자바 코드를 생성한다.
      
      JSTL : JSP에서 사용할 수 있는 특별한 확장태그.
      => 특정 자바코드를 생성한다.
      =>별도로 API 및 구현체를 다운로드 해야한다.
 --%>
<jsp:useBean id="score" class="servlets.step04.Score" scope="page"/>
<%--위 소스를 자바소스로 
    Score score = new Score(); 
    pageContext.setAttribute("score",score);
--%>
	<jsp:setProperty property="name" name="score" value="홍길동"/>
	<%--
  위소스를 자바소스로	
	score.setName("홍길동"); --%>
	<jsp:setProperty property="kor" name="score" value="100"/>
	<jsp:setProperty property="eng" name="score" value="100"/>
	<jsp:setProperty property="math" name="score" value="100"/>

<%--Expression Element를 사용하여 객체 값 출력 --%>
<%=score.getName() %><br>
<%=score.getKor() %><br>
<%=score.getEng() %><br>
<%=score.getMath() %><br>
<%=score.getTotal() %><br>
<%=score.getAverage() %><br>

<%-- Expression Language를 사용하여 객체 값 얻기 
${객체명.프로퍼티명} 또는 ${객체명["프로퍼티명"]}
객체는 다음의 보관소에서 찾는다. 로컬 변수는 찾지 않는다.
JspContext(page) 
    => ServletRequest(request)
    => HttpSession(session) 
    => ServletContext(application) 
    => null
--%>

${score.name }<br>
${score["name"] }<br>


</body>
</html>