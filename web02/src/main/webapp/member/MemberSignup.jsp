<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
<h1>학생등록</h1>
<h2>기본정보</h2>
<form action="signup2.do" method="post" enctype="multipart/form-data">
이름: <input type="text" name="name"><br>
이메일: <input type="email" name="email"><br>
전화: <input type="tel" name="tel"><br>
암호: <input type="password" name="password" ><br>
사진: <input type="file" name="photo"><br>
<input type="submit" value="다음">
</form>
</body>
</html>

