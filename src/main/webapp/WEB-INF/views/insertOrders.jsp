<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function xqty(){
		var playerqty = insert.orderqty.value;
		
	insert.price.value= playerqty * ${svo.now}; //컨트롤러에서  mav.addObject("svo", sdao.detail(stockno)) 를 통해 stock의 vo정보를 svo에 넣어 두고 있었음
	}
</script>
</head>
<body>
	<h2>주식구매</h2>
	<hr>
	<form action="/insertOrders.do" method="post" name="insert">
		<input type="hidden" name="stockno" value="${svo.stockno }">
		
		<input type="hidden" name="memberno" value="${login.memberno }">
			수량: <input type="number" name="orderqty" onkeyup="xqty()">
			가격 : <input type="number" name="price">
		<input type="submit" value="구매">
		<input type="reset" value="취소">
	</form>
</body>
</html>