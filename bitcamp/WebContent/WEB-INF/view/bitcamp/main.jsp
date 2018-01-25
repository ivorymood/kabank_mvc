<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<link rel="stylesheet" href="${css}/bitcamp.css" />
<body>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
<section id= "wrapper">	
<article>
	

</article>
<article>
	<h1>비트캠프 메인</h1>
	<form id="bit_form" action="">
		<table id="bit_table">
			<tr>
				<th>상태</th>
				<th>월</th>
				<th>화</th>
				<th>수</th>
				<th>목</th>
				<th>금</th>
			</tr>
			<tr>
				<td>결석</td>
				<td><input type="radio" name="monday" value="absent" checked/></td>
				<td><input type="radio" name="tuesday" value="absent" checked/></td>
				<td><input type="radio" name="wednesday" value="absent" checked/></td>
				<td><input type="radio" name="thursday" value="absent" checked/></td>
				<td><input type="radio" name="friday" value="absent" checked/></td>
			</tr>
			<tr>
				<td>지각</td>
				<td><input type="radio" name="monday" value="late" /></td>
				<td><input type="radio" name="tuesday" value="late"/></td>
				<td><input type="radio" name="wednesday" value="late"/></td>
				<td><input type="radio" name="thursday" value="late"/></td>
				<td><input type="radio" name="friday" value="late"/></td>
			</tr>
			<tr>
				<td>조퇴</td>
				<td><input type="radio" name="monday" value="early" /></td>
				<td><input type="radio" name="tuesday" value="early"/></td>
				<td><input type="radio" name="wednesday" value="early"/></td>
				<td><input type="radio" name="thursday" value="early"/></td>
				<td><input type="radio" name="friday" value="early"/></td>
			</tr>
			<tr>
				<td>출석</td>
				<td><input type="radio" name="monday" value="attend" /></td>
				<td><input type="radio" name="tuesday" value="attend"/></td>
				<td><input type="radio" name="wednesday" value="attend"/></td>
				<td><input type="radio" name="thursday" value="attend"/></td>
				<td><input type="radio" name="friday" value="attend"/></td>
			</tr>
			<tr>
				<td>결과</td>
				<td><input type="text" name="result"/></td>
				<td><input type="text" name="result"/></td>
				<td><input type="text" name="result"/></td>
				<td><input type="text" name="result"/></td>
				<td><input type="text" name="result"/></td>
			</tr>
			<tr>
				<td colspan=6>
					<input type="hidden" name="id" value="b"/>
					<button id="attend_result">확인</button>
				</td>
			</tr>
		</table>
	</form>
</article>
</section>
	
<%@ include file="../common/footer.jsp" %>
</body>

</html>