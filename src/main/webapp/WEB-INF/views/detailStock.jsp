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
	<h2><a href="/listStock.do">주식상세</a></h2>
	<hr>
	주식번호 : ${s.stockno }<br>
	주식이름 : ${s.stockname }<br>
	수량 : ${s.qty }<br>
	현재가 : ${s.now }<br>
	상한가 : ${s.max }<br>
	하한가 : ${s.min }<br>
	<c:if test="${login.id ne 'admin' }">
	<a href="/insertOrders.do?stockno=${s.stockno }">상품구매</a>
	</c:if>
	<c:if test="${login.id eq 'admin' }">
	<a href="/deleteStock.do?stockno=${s.stockno }">주식삭제</a>
	<a href="/updateStock.do?stockno=${s.stockno }">주식수정</a><br>
	</c:if>
</body>
</html>