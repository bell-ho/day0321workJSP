<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인</h2>
	<hr>
	<form action="/loginMember.do" method="post">
		아이디 : <input type="text" name="id">
		<input type="submit" value="로그인">
		<a href="/insertMember.do">회원가입</a>
	</form>
</body>
</html>
