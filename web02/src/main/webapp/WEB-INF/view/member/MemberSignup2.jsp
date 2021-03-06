<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
<h1>학생 등록</h1>
<h2>추가정보</h2>
<form action="signup3.do" method="post" enctype="multipart/form-data"> 
우편번호: <input id="postNo" type="text" name="postNo" onclick="onSearchPostNo();" readonly><br>
기본주소: <input id="baseAddress" type="text" name="baseAddress" readonly size="70"><br>
상세주소: <input id="detailAddress" type="text" name="detailAddress" size="70"><br>
학교: <input type="text" name="school" ><br>
학년: <select name="grade">
  <option value="1학년">1학년</option>
  <option value="2학년">2학년</option>
  <option value="3학년">3학년</option>
  <option value="4학년">4학년</option>
  <option value="휴학">휴학</option>
  <option value="졸업">졸업</option>
</select><br>
전공: <input type="text" name="major"><br>
재직자: <input type="radio" name="working" value="Y">취업
<input type="radio" name="working" value="N" checked>미취업<br>
회사명: <input type="text" name="company"><br>
사업자번호: <input type="text" name="companyNo"><br>
<input type="submit" value="다음">
</form>
<script src="http://dmaps.daum.net/map_js_init/postcode.js"></script>
<script>
function onSearchPostNo(){
	 new daum.Postcode({
	        oncomplete: function(data) {
	            var postNo = document.getElementById("postNo");
	            var baseAddress = document.getElementById("baseAddress");
	            var detailAddress = document.getElementById("detailAddress");
	            
	            postNo.value = data.postcode1 + "-" + data.postcode2;
	            baseAddress.value = data.address;
	            detailAddress.focus();
	        }
	 }).open();
}
</script>
</body>
</html>