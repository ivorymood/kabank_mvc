package com.kabank.mvc.factory;

import com.kabank.mvc.enums.Action;

public class ActionFactory {
	public static Action create(String x) {
		Action action = null;
		if(x==null || x.equals("") == true) {x="move";} //방어코딩. 에러안나게.
		System.out.println("ACTION FACTORY move 입력 x:" + x);
		switch (x) {
		case "move":
			action = Action.MOVE;
			break;
		case "login":
			action = Action.LOGIN;
			break;
		case "change_pass":
			action = Action.CHANGE_PASS;
			break;
		case "delete":
			action = Action.DELETE;
			break;
		case "logout":
			action = Action.LOGOUT;
			break;
		case "join": 
			action = Action.JOIN;
			break;
		case "create":
			action = Action.CREATE;
			break;
		case "open_account":
			action = Action.OPEN_ACCOUNT;
			break;
		case "create_number":
			action = Action.CREATE_NUMBER;
			break;
		case "my_page":
			action = Action.MYPAGE;
			break;
		default:
			action = Action.MOVE;
			break;
		}
		System.out.println("ACTION IS "+action.toString());
		return action;
	}
}
