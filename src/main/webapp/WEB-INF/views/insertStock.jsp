<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>주식등록</h2>
	<hr>
	<form action="/insertStock.do" method="post">
	주식명 : <input type="text" name="stockname"><br>
	   수량 : <input type="number" name="qty"><br>
	현재가 : <input type="number" name="now"><br>
	상한가 : <input type="number" name="max"><br>
	하한가 : <input type="number" name="min"><br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>
</body>
</html>