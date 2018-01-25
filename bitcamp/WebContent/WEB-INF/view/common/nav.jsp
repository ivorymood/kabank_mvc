<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav id="nav">
	<ul >
		<li>
			<a id="burgerking"  >버거킹</a>
		</li>		<!--자기자신한테 링크거는 거면 #을 치면 됨. 새로고침과 같은 효과  -->
		<li>
			<a id="kakao" >카카오뱅크</a>
		</li>
		<li>
			<a id="bitcamp" >비트캠프</a>
		</li>
		<li>
			<a id="mobile" >모바일</a>
		</li>
		<li>
			<a id="lotto" >로또</a>
		</li>
		<li>
			<a id="mypage" >마이페이지</a>
		</li>
		<li>
			<a id="logout" >로그아웃</a>
		</li>
	</ul>
</nav>	
<script>
document.querySelector('#burgerking').addEventListener('click', function(){
	location.href="${ctx}/user.do?cmd=move&dir=burgerking&page=main";
}, false);
document.querySelector('#kakao').addEventListener('click', function(){
	location.href="${ctx}/kakao.do?dir=kakao&page=main";
}, false);
document.querySelector('#bitcamp').addEventListener('click', function(){
	location.href="${ctx}/kakao.do?dir=bitcamp&page=main";
}, false);
document.querySelector('#mobile').addEventListener('click', function(){
	location.href="${ctx}/kakao.do?dir=mobile&page=main";
}, false);
document.querySelector('#lotto').addEventListener('click', function(){
	location.href="${ctx}/kakao.do?dir=lotto&page=main";
}, false);
document.querySelector('#mypage').addEventListener('click', function(){
	location.href="${ctx}/kakao.do?dir=user&page=mypage";
}, false);
document.querySelector('#logout').addEventListener('click', function(){
	location.href="${ctx}/user.do?cmd=logout&dir=user&page=login";
}, false);
</script>