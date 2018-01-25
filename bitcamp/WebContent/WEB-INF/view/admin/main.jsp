<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<link rel="stylesheet" href="${css}/admin.css" />
<body>
	<div class="grid-container">
		<div class="grid-item"></div>
		<div class="grid-item"></div>
		<div class="grid-item"></div>
		<div class="grid-item"></div>
		<div class="grid-item"></div>
		<div class="grid-item"></div>
		<div class="grid-item"></div>
		<div class="grid-item"></div>
		<div class="grid-item"></div>
	</div>
	<section id="wrapper">
		<article id="admin_header">
			<h1>관리자 메인 페이지</h1>
		</article>
	<aside id="admin_aside">
		<a id="member_mgmt_link">회원관리</a>
	</aside>
		<article id="admin_body">
			<table id="admin_table" >
				<tr>
					<td>
						<button id="create_table_btn">테이블 생성</button>
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td>테이블 생성 <br/>
						<form id="create_table_form" action="${ctx}/admin.do">
							<select name="select_table" id="select_table">
								<option value="member">회원테이블</option>
								<option value="attend">출석테이블</option>
								<option value="bank">뱅크테이블</option>
								<option value="mobile">전화테이블</option>
							</select>
							<button id="create_table_btn" name="create_table_btn">생성</button>
							<input type="hidden" name="cmd" value="create" />
						</form>
					</td>
				</tr>
			</table> 
		</article>
	</section>
<%@ include file="../common/footer.jsp" %>
</body>
<script>
document.querySelector("#create_table_btn").addEventListener('click', function(e){
	document.querySelector("#create_table_form").submit;
	//dd
}, false);	
</script>
</html>