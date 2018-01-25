<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>


<!doctype html>
<html lang="en">
<link rel="stylesheet" href="${css}/member_list.css" />
<body>
	<section id="wrapper">
		<article id="admin_header">
			<h1>관리자 메인 페이지</h1>
		</article>
	<aside id="admin_aside">
		<a>회원관리</a>
	</aside>
		<article id="admin_body">
			<select name="member_select" id="member_select">
				<option value="id" checked>ID</option>
				<option value="name">이름</option>
				<option value="gender">성별</option>
			</select>
			<input id="input_member" type="text" />
			<button id="search_member_btn">검색</button><br/>
			
			<table id="member_table" >
				<tr>
					<th>NO.</th>
					<th>ID</th>
					<th>이    름</th>
					<th>생년월일</th>
					<th>성    별</th>
					<th>전화번호</th>
					<th>이 메 일</th>
					<th>주    소</th>
				</tr>
				
							
				
			</table> 
			<button id="member_register_form_btn">추가</button>
		</article>
	</section>
<%@ include file="../common/footer.jsp" %>
</body>
	<script src="../../js/admin/member_list.js"></script>

</html>