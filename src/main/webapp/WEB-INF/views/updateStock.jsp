<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>주식수정</h2>
	<hr>
	<form action="/updateStock.do" method="post">
	  <input type="hidden" name="stockno" value="${s.stockno }">
		주식번호 : ${s.stockno }<br>
		주식이름 : <input type="text" name="stockname" value="${s.stockname }"><br>
		수량 : <input type="number" name="qty" value="${s.qty }"><br>
		현재가 : <input type="number" name="now" value="${s.now }"> <br>
		상한가 : ${s.max }<br>
		하한가 : ${s.min }<br>
		<input type="submit" value="수정">
	</form>
</body>
</html>