<%@page import="servlets.step05HW.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 변경폼</title>
</head>
<body>
<h1>회원 변경(EL)</h1>
<form action="update.do" method="post">
번호: <input type="text" name="mno" value='${requestScope.person.no }' readonly><br>
이름: <input type="text" name="name" value='${person.name }'><br>
이메일: <input type="text" name="email" value='${person.email }'><br>
전화번호: <input type="text" name="tel" value='${person.tel }'><br>
암호 : <input type="password" name="pwd"><br>
<input type="submit" value="변경">
</form>
<jsp:include page="/score/step05HW/copyright.jsp"/>
</body>
</html>
