<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
	<form id="change_pass_form" action="${ctx}/user.do">
	<table>
		<tr>
			<td>현재 비밀번호</td>
			<td>${sessionScope.user.pass}</td>
		</tr>
		<tr>
			<td>바꿀 비밀번호</td>
			<td><input type="text" id="new_pass" name="new_pass"/></td>
		</tr>
		<tr>
			<td>한번더 입력</td>
			<td><input type="text" id="re_pass" name="re_pass"/></td>
		</tr>
		<tr>
			<td colspan=2>
				<button id="change_pass_btn" name="change_pass_btn">확인</button>
				<button id="cancle_btn" name="cancle_btn">취소</button>
			</td>
		</tr>
	</table>
	<input type="hidden" name="pass" value="${sessionScope.user.pass}" />
	<input type="hidden" name="cmd" value="change_pass" />
	<input type="hidden" name = "dir" value = "bitcamp" />
	<input type="hidden" name = "page" value = "main"/>
	</form>
</body>
<script>
document.querySelector("#cancle_btn").addEventListener('click', function(e){
	e.preventDefult();
	location.href="${ctx}/user.do?cmd=move&dir=bitcamp&page=main";
}, false);
document.querySelector("#change_pass_btn").addEventListener('click', function(e){
	document.querySelector("#change_pass_form").submit;
}, false);
</script>
</html>