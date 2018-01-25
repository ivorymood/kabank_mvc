/**
 * 
 */
window.addEventListener("load", init, false);
function init(){
	document.querySelector('#member_register_btn').addEventListener("click", memberRegister, false);
}
function memberRegister(){
	alert('click');
	document.querySelector('#member_register_form').submit;	//2번
	//location.href="member_register.jsp";  //1번
	//1번과 2번중 뭐가 더 빠를까? 1번! 2번은 value를 바리바리싸들고 간다.
}