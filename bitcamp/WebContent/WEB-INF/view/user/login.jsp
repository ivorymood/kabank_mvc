<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<body>
<div id="wrapper">
	<header id="index_header">
		<h1><a id="home_text">BIT CAMP SAMPLE PROJECT</a></h1>
	</header>
	<section id="index_section">
		<article>
			<table id="index_table">
				<tr id="first_child">
					<td colspan="5">
						<form id="login_form" action="${ctx}/user.do">
							<table id="index_login_box" >
			 					<tr>
			 						<td > 
			 						</td>
			 						<td  rowspan="2">
				 						<button id="index_login_btn">로그인</button>
									</td>
			 					</tr>
			 					<tr>
			 						<td >
			 						<input id="index_input_id" type="text" name="id" placeholder="id"/>
			 						<input id="index_input_pw" type="text" name="pass" placeholder="pass"/>
			 						<input type="hidden" name = "cmd" value = "login"/>
			 						<input type="hidden" name = "dir" value = "user" />
			 						<input type="hidden" name = "page" value = "mypage"/>
			 						</td>
			 					</tr>
			 				</table>
						</form>
						<a id="go_admin_link" href="#">관리자</a>
						<a id="go_join_link" href="#">회원가입</a>
						<a id="go_jdbc_link" href="#">JDBC TEST</a>
						<!--값을 넘겨줄 것이 없는건 a태그+js외부파일  -->
					</td>
				</tr>
			</table>	
		</article>
	</section>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
<script>
document.querySelector('#go_join_link').addEventListener('click', 
		function (){
	location.href="${ctx}/user.do?cmd=move&dir=user&page=join";
}, false);
document.querySelector('#go_jdbc_link').addEventListener('click', function (){
	location.href="${ctx}/common/jdbc_test.do";
}, false);
document.querySelector('#index_login_btn').addEventListener('click', function (){
	document.querySelector('#login_form').submit;
}, false);
document.querySelector('#go_admin_link').addEventListener('click', function(){
	location.href="${ctx}/user.do?cmd=move&dir=admin&page=main";
}, false);
//function을 안에 넣으면 anonymous 함수로 처리할 수 있다. 이름지을 필요 X
</script>
</html>