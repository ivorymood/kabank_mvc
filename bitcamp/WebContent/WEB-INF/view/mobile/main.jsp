<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<body>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
	<section id= "wrapper">	
		<article>
			<h1>telecom 메인</h1>
			<table>
				<tr>
					<td>
					<button id="create_number_btn" name="create_number_btn">개통</button>
					</td>
					<td>
					<button id="move_number_btn" name="move_number_btn">번호이동</button>
					</td>
					
				</tr>
			</table>
		</article>
	</section>
<%@ include file="../common/footer.jsp" %>
</body>
<script>
document.querySelector("#create_number_btn").addEventListener('click', function(){
	location.href="${ctx}/mobile.do?cmd=create_number&dir=user&page=mypage";
}, false);
</script>
</html>