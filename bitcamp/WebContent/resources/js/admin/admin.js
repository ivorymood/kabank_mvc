/**
 * 
 */
window.addEventListener("load", init, false);
function init(){
	var createTableLink = document.querySelector('#create_table_btn');
	var memberMgmtLink = document.querySelector('#member_mgmt_link');
	createTableLink.addEventListener("click", createTable, false);
	memberMgmtLink.addEventListener("click", memberMgmt, false);
}
function createTable(e){
	alert('알로!');
	location.href="member_list.jsp";
}
function memberMgmt(){
	location.href="member_list.jsp";
}
