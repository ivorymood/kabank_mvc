<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="${css}/join.css" />
<body>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
<div id="wrapper">
	<section>
		<article>
			<header id="join_second_header">
				<hgroup>
					<h1>MEMBER JOIN</h1>
					<h2>일반회원가입</h2>
				</hgroup>
			</header>
		</article>
		<form id="#join_form" action="${ctx}/user.do">
			<article id="join_prg">
				<table id="join_table">
					<tr>
						<td>아이디</td>
						<td>
							<input id="join_id" name="join_id" 
							 type="text" name="id" /> 
							<button id="check_id_btn" name="check_id_btn">아이디 중복 확인</button>
							* 영문소문자로 시작하는 6~12자 영문소문자 또는 숫자 (공백, 특수문자 불가)<br/>
						</td>
					</tr>
					<tr>
						<td>이름</td>
						<td>
							<input id="join_name" name="join_name" 
							type="text" /> * 반드시 실명을 입력해 주세요.<br/>
						</td>
					</tr>
					<tr>
						<td>주민번호</td>
						<td>
							<input id="join_first_ssn" name="join_first_ssn"  type="text"  /> 
							- <input id="join_second_ssn" name="join_second_ssn"  type="text" style="width: 20px"/> 
							* 생년월일과 앞번호만 입력<br/>
						</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td>
							<input id="join_first_email" name="join_first_email"   /> @
							<select name="join_email_select" id="email" >
								<option value="">직접입력</option>
								<option value="gmail.com">gamil.com</option>
								<option value="naver.com">naver.com</option>
								<option value="hanmail.net">hanmail.net</option>
								<option value="daum.net">daum.net</option>
							</select>
								<button>중복 확인</button>
						</td>
					</tr>
					<tr>
						<td>연락처</td>
						<td>
							<select name="join_phone_agency" id="">
								<option value="skt">SKT</option>
								<option value="kt">KT</option>
								<option value="lg">LG</option>
							</select>
							<select id="join_first_num" name="join_first_num">
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="02">02</option>
							</select> 
							- <input id="join_second_num" name="join_second_num"  type="tel"/> 
							- <input id="join_third_num" name="join_third_num"  type="tel"/><br/>
						</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td>
							<input id="join_pass" name="join_pass" type="text"  /> 
							* 영문소문자, 영문소문자 + 숫자 6~12자 내외 (공백, 특수문자 불가)<br/>
						</td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td>
							<input id="join_repass" name="join_repass" type="text"  /> <br/>
						</td>
					</tr>
					<tr>
						<td>주소</td>
						<td>
							<input id="join_first_addr" name="join_first_addr" type="text" /> 
							<button>주소 검색</button> <br/>
							<input id="join_second_addr" name="join_second_addr" type="text"/> 
							<input id="join_third_addr" name="join_third_addr" type="text" /> 
							<input id="join_fourth_addr" name="join_forth_addr" type="text"/><br/>
						</td>
					</tr>
					<tr>
						<td>사진등록</td>
						<td>
							<input id="join_file" type="file" name="profile"/> 
							<button>사진 등록</button>
						</td>
					</tr>
					<tr>
						<td>
							가입일
						</td>
						<td>
							<input type="date" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="hidden" name="cmd" value="join"/>
							<input type="hidden" name="dir" value="user"/>
							<input type="hidden" name="page" value="login"/>
							<button id="join_confirm_btn" name="join_confirm_btn">확  인</button>
							<button id="join_cancle_btn" name="join_cancle_btn">취  소</button>
						</td>
					</tr>
				</table>
			</article>
		</form>
	</section>
</div>S
<%@ include file="../common/footer.jsp" %>
</body>
<script>
document.querySelector('#join_confirm_btn').addEventListener('click', function (e){
	alert('가입 확인 클릭' + joinId + ' : ' + joinRepass);
	document.querySelector('#join_form').submit;
}, false);
document.querySelector('#check_id_btn').addEventListener('click', function (e){
	alert('중복체크 클릭');
	e.preventDefault();
}, false);
</script>
</html>