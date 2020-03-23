<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr>
	<table border="1" width="80%">
		<tr>
			<td>주식번호</td>
			<td>주식명</td>
			<td>수량</td>
			<td>현재가</td>
			<td>상한가</td>
			<td>하한가</td>
		</tr>
		<c:forEach var="s" items="${list }">
			<tr>
				<td>${s.stockno }</td>
				<td>
				<a href="/detailStock.do?stockno=${s.stockno }">${s.stockname }</a>
				</td>
				<td>${s.qty }</td>
				<td>${s.now }</td>
				<td>${s.max }</td>
				<td>${s.min }</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${login.id ne 'admin' }">
		<a href="/listOrders.do?memberno=${login.memberno}">구매주식보러가기</a>
<!-- 		memberno로 전해줘야 그 멤버만의 구매리스트가 보임 -->
	</c:if>
	<c:if test="${login.id eq 'admin' }">
		<a href="/insertStock.do">주식등록</a>
	</c:if>
</body>
</html>