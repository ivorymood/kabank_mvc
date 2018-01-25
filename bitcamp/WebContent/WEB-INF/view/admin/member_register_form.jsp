<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<link rel="stylesheet" href="${css}/member_register_form.css" />
<body>
	<section id="wrapper">
		<article id="admin_header">
			<h1>관리자 메인 페이지</h1>
		</article>
	<aside id="admin_aside">
		<a>회원관리</a>
	</aside>
		<article id="admin_body">
		<form id="member_register_form" action="member_register.jsp">
			<table id="member_table" >
				<tr>
					<td><i class="fa fa-chevron-right"></i>ID</td>
					<td><input id="id" name="id" type="text" /></td>
				</tr>
				<tr>
					<td><i class="fa fa-chevron-right"></i>이    름</td>
					<td><input id="name" name="name" type="text" /></td>
				</tr>
				<tr>
					<td><i class="fa fa-chevron-right"></i>비밀번호</td>
					<td><input id="pass" name="pass" type="text" /></td>
				</tr>
				<tr>
					<td><i class="fa fa-chevron-right"></i>성    별</td>
					<td><input id="gender" name="gender" type="text" /></td>
				</tr>
				<tr>
					<td><i class="fa fa-chevron-right"></i>전화번호</td>
					<td><input id="phone" name="phone" type="text" /></td>
				</tr>
				<tr>
					<td><i class="fa fa-chevron-right"></i>이 메 일</td>
					<td><input id="email" name="email" type="text" /></td>
				</tr>
				<tr>
					<td><i class="fa fa-chevron-right"></i>주    소</td>
					<td><input id="addr" name="addr" type="text" /></td>
				</tr>
			</table> <br/>
			<button id="member_register_btn">추가</button>
		</form>
		</article>
	</section>
<%@ include file="../common/footer.jsp" %>
</body>
	<script src="../../js/admin/member_register_form.js"></script>

</html>