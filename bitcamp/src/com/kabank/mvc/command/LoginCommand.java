package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.iterator.ParamsIterator;

public class LoginCommand implements IOrder {
	Map<?,?> map;
	String servletPath;
	HttpSession session;
	public LoginCommand(HttpServletRequest request) {
		map = ParamsIterator.execute(request);
		servletPath = request.getServletPath().split("/")[1].split("\\.")[0];
		session = request.getSession();
	}
	@Override
	public void execute() {
		switch(servletPath) {
		case "user":
			System.out.println("==LoginCommand의 user.do==");
			String id = String.valueOf(map.get("id"));
			String pass = String.valueOf(map.get("pass"));
			InitCommand.cmd.setColumn("id/pass");
			InitCommand.cmd.setData(id + "/" + pass);
			break;
		
		case "mobile":
			System.out.println("==LoginCommand의 telelcom.do==");
			InitCommand.cmd.setData(((MemberBean) session.getAttribute("user")).getId());
			InitCommand.cmd.setSql(
					"SELECT "
					+ "customer_num, "
					+ "phone_num, "
					+ "reg_date, "
					+ "id "
					+ "FROM "
					+ "MOBILE "
					+ "WHERE "
					+ "id = '"+ InitCommand.cmd.getData() + "' "
					+ "order by customer_num");
			System.out.println("LoginCommand의 : "+InitCommand.cmd.getSql());
			break;
		}
	}
}
