function init(){
	var goAdminLink = document.querySelector('#go_admin_link');
	var goJoinLink = document.querySelector('#go_join_link');
	var indexLoginBtn = document.querySelector('#index_login_btn');
	goAdminLink.addEventListener("click", goAdmin, false);
	goJoinLink.addEventListener("click", goJoin, false);
	indexLoginBtn.addEventListener("click", indexLogin, false);
}
// === 는 자바에서 .equals()와 같다. //'' "" 둘중 어떤걸 써도 ㅇㅋ
function indexLogin(e){
	var loginId = document.querySelector('#index_input_id').value;
	var loginPass = document.querySelector('#index_input_pw').value;
	var joinId = sessionStorage.getItem('id');
	var joinPass = sessionStorage.getItem('pass');
	if(!(loginId === joinId) || !(loginPass === joinPass)){
		alert('아이디' + loginId + '또는 비밀번호'+loginPass+ '는 틀립니다');
		e.preventDefault();
	}
}
function goAdmin(){
     if(confirm('관리자?')){
          location.href="admin/main.jsp";
     }else{
           alert('관리자만 접근가능 합니다');
     }
}
function goJoin(){
	location.href = "user/join_form.jsp";
}
window.addEventListener("load", init, false);