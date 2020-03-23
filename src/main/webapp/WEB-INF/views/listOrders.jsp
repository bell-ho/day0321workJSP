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
	<h2>
		<a href="/listStock.do">주식상품으로</a>
	</h2>
	<table border="1" width="80%">
		<tr>
			<td>구매번호</td>
			<td>주식번호</td>
			<td>구매수량</td>
			<td>구매가격</td>
			<c:if test="${login ne 'admin' }">
				<td>구매취소</td>
			</c:if>
		</tr>
		<c:forEach var="o" items="${list }">
			<tr>
				<td>${o.orderno }</td>
				<td>${o.stockno }</td>
				<td>${o.orderqty }</td>
				<td>${o.price }</td>

				<c:if test="${login ne 'admin' }">
					<td><a href="/deleteOrders.do?orderno=${o.orderno }">구매취소</a>
					</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>

</body>
</html>