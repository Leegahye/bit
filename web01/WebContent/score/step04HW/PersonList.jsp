<%@page import="java.util.ArrayList"%>
<%@page import="servlets.step04HW.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리(MVC)</title>
<style type="text/css">
table {
  font-family: verdana,arial,sans-serif;
  font-size:11px;
  color:#333333;
  border-width: 1px;
  border-color: #666666;
  border-collapse: collapse;
}
table th {
  border-width: 1px;
  padding: 8px;
  border-style: solid;
  border-color: #666666;
  background-color: #dedede;
}
table td {
  border-width: 1px;
  padding: 8px;
  border-style: solid;
  border-color: #666666;
  background-color: #ffffff;
}
</style>
</head>
<body>
<h1>회원 관리(MVC)</h1>
<a href='personform.html'>추가</a>
<table>
<tr>
  <th>번호</th> 
  <th>이름</th> 
  <th>이메일</th> 
  <th>전화번호</th> 
  <th></th>
</tr>

<c:forEach var="person" items="${persons }">

<tr>
    <td>${person.no}</td>   
    <td><a href='update?mno=${person.no}'>${person.name}</a></td>   
    <td>${person.email}</td>   
    <td>${person.tel}</td>   
    <td><a href='delete?no=${person.no }'>삭제</a></td>
    </tr>
</c:forEach>

</table>
<jsp:include page="/score/step04HW/copyright.jsp"></jsp:include>
</body>
</html>
