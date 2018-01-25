package com.kabank.mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.factory.SqlFactory;

public class DeleteCommand implements IOrder {
	HttpSession session;
	public DeleteCommand(HttpServletRequest request) {
		session = request.getSession();
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		MemberBean myMember = (MemberBean)session.getAttribute("user");
		InitCommand.cmd.setSql(
				SqlFactory.delete(TnameEnum.MEMBER.getValue(), myMember.getId()));
	}

}
