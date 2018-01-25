/**
 * 
 */
function init(){
	var arr=['burgerking', 'kakao', 'bitcamp', 'sktelecom', 'lotto'];
	for(var i=0; i<arr.length; i++){
		document.querySelector('#'+arr[i]).addEventListener('click', 
			function(e){location.href = "../"+this.id+"/main.jsp";
		},false);
	}
	document.querySelector('#header_home').addEventListener('click',
			function(e){location.href = "../index.jsp";
		},false);
	document.querySelector('#header_logout').addEventListener('click',
			function(e){location.href = "../index.jsp";
		},false);
	document.querySelector('#footer_bit').addEventListener('click',
			function(e){location.href = "http://bitcamp.co.kr/index.php?main_page=home";
		},false);
	var checkIdDuplBtn = document.querySelector('#check_id_btn');
	var joinConfirmBtn = document.querySelector('#join_confirm_btn');
	var joinPass = document.querySelector('#join_pass').value;
	/*if(joinPass === joinRepass){
		sessionStorage.setItem('pass',joinRepass);
	}else{
		alert('비밀번호가 일치하지 않습니다');
	}*/
	checkIdDuplBtn.addEventListener("click", checkIdDupl, false);
	joinConfirmBtn.addEventListener("click", joinConfirm, false);
}
function checkIdDupl(e){	//클릭 이벤트는 e를 주자
	alert('중복체크 클릭');
	e.preventDefault();
}
function joinConfirm(e){
	var joinId = document.querySelector('#join_id').value;
	var joinRepass = document.querySelector('#join_repass').value;
	alert('가입 확인 클릭' + joinId + joinRepass);
	sessionStorage.setItem('id',joinId);
	sessionStorage.setItem('pass', joinRepass);
	document.querySelector('#join_form').submit;
}
window.addEventListener("load", init, false);
