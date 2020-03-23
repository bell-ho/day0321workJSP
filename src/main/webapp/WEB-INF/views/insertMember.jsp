<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원등록</h2>
	<hr>
	<form action="/insertMember.do" method="post">
	아이디 : <input type="text" name="id" required="required">
	<input type="submit" value="등록">
	</form>
</body>
</html>