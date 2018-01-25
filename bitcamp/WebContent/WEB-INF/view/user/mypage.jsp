<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<body>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
<article>
	<form id="profile_form" action="${ctx}/user.do">
	<table id="mypage_table">
		<tr>
			<td id = "profile" rowspan="6"><img src="${img}/basic_profile.png"></td>
			<td class = "column">ID</td>
			<td class="content">${sessionScope.user.id }</td>
			<td class = "column">SSN</td>
			<td class="content">${sessionScope.user.ssn }</td>
		</tr>
		<tr>
			<td class = "column">PASS</td>
			<td class="content">${sessionScope.user.pass }</td>
			<td class = "column">빈칸</td>
			<td class="content"></td>
		</tr>
		<tr>
			<td class = "column">NAME</td>
			<td class="content">${sessionScope.user.name }</td>
			<td class = "column">EMAIL</td>
			<td class="content">${sessionScope.user.email }</td>
		</tr>
		<tr>
			<td class = "column">GENDER</td>
			<td class="content">${sessionScope.user.ssn }</td>
			<td class = "column">ADDRESS</td>
			<td class="content">${sessionScope.user.addr }</td>
		</tr>
		<tr>
			<td class = "column">ACCOUNT</td>
			<td>${sessionScope.user.kakao.accountNum }</td>
			<td class = "column">MONEY</td>
			<td>${sessionScope.user.kakao.money }</td>
		</tr>
		<tr>
			<td class = "column">PHONE</td>
			<td>${sessionScope.user.mobile.phoneNum }</td>
			<td class = "column">REGDATE</td>
			<td>${sessionScope.user.mobile.regDate }</td>
		</tr>
	</table>
	<button id="pass_change_btn">비밀번호 변경</button>
	<input type="hidden" name="cmd" value="move"/>
	<input type="hidden" name="page" value="change_pass"/>
	<input type="hidden" name="dir" value="bitcamp"/>
	</form>
	<button id="delete_btn">회원탈퇴</button>
</article>
</body>
<script>
document.querySelector("#pass_change_btn").addEventListener('click', function(){
	alert('비밀번호 변경?');
	document.querySelector("#profile_form").submit;
}, false);
document.querySelector("#delete_btn").addEventListener('click', function(){
	alert('정말 탈퇴하시겠습니까?');
	location.href="${ctx}/user.do?cmd=delete&dir=user&page=login";
}, false);

</script>
</html>