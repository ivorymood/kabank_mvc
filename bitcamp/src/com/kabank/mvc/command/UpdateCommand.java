package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.factory.SqlFactory;
import com.kabank.mvc.iterator.ParamsIterator;

public class UpdateCommand implements IOrder{
	Map<?,?> map;
	HttpSession session;
	public UpdateCommand(HttpServletRequest request) {
		map = ParamsIterator.execute(request);
		session = request.getSession();
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		InitCommand.cmd.setColumn("pass");
		InitCommand.cmd.setData(String.valueOf(map.get("new_pass")));
		MemberBean myMember = (MemberBean)session.getAttribute("user");
		myMember.setPass(InitCommand.cmd.getData());
		session.setAttribute("user", myMember);
		InitCommand.cmd.setSql(
				SqlFactory.update(TnameEnum.MEMBER.getValue(),
				InitCommand.cmd.getColumn(), myMember.getPass(), 
				"id", myMember.getId())
				);
		
	}
}
