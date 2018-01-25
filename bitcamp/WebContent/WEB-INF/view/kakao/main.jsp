<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<body>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
	<section id= "wrapper" >	
		<article>
		<table>
			<tr>
				<td>
				<button id="open_account_btn" name="open_account_btn">통장개설</button>
				</td>
				<td>
				<button id="deposit_btn" name="deposit_btn">입금</button>
				</td>
				<td>
				<button id="withdraw_btn" name="withdraw_btn">출금</button>
				</td>
				<td>
				<button id="transfer_btn" name="transfer_btn">송금</button>
				</td>
				<td>
				<button id="close_account_btn" name="close_account_btn">통장해지</button>
				</td>
			</tr>
		</table>		
		</article>	
	</section>		
<%@ include file="../common/footer.jsp" %>
</body>
<script>
document.querySelector("#open_account_btn").addEventListener('click', function(){
	location.href = "${ctx}/kakao.do?cmd=open_account&dir=user&page=mypage";
}, false);
</script>
</html>