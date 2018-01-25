<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<body>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
	<section id= "wrapper">	
		<article>
			<form action="result.jsp">
				구매 금액 : <input type="text" name="money" placeholder = "게임당 1000원 최대 5게임"/>
				<input type="submit" value = "전송"/>
			</form>
		</article>
	</section>
<%@ include file="../common/footer.jsp" %>
</body>
</html>