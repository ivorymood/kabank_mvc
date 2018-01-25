/**
 * 
 */
window.addEventListener("load", init, false);
function init(){
	document.querySelector('#member_register_form_btn').addEventListener("click", addMember, false);
}
function addMember(e){
	alert('클릭');
	location.href="member_register_form.jsp";
}

