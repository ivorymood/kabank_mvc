package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.InsertCommand;
import com.kabank.mvc.command.LoginCommand;
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.command.SelectIfExistCommand;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.domain.MobileBean;
import com.kabank.mvc.serviceImpl.MobileServiceImpl;
import com.kabank.mvc.util.DispatcherServlet;

@WebServlet("/mobile.do")
public class MobileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("===========MOBILE 서블릿 내부로 들어옴===========");
		HttpSession session = request.getSession();
		new InitCommand(request).execute();
		switch (InitCommand.cmd.getAction()) {
		case CREATE_NUMBER:
			System.out.println("====MOBILE-C: CREATE_NUMBER IN====");
			boolean exist = true;
			InitCommand.cmd.setData(((MemberBean) session.getAttribute("user")).getId());
			while (exist) {
				new SelectIfExistCommand(request).execute();
				Object number = MobileServiceImpl.getInstance().searchNumber();
				if (number == null) {
					System.out.println("검색 결과 이미 있는 전화번호 없음");
					new InsertCommand(request).execute();
					exist = false;
				} else {
					System.out.println("전화번호 다시 만들기");
				}
			}
			MobileServiceImpl.getInstance().createNumber();
			new LoginCommand(request).execute();
			MobileBean mobile = (MobileBean) MobileServiceImpl.getInstance().findMobileById();

			MemberBean tmp = ((MemberBean) session.getAttribute("user"));
			tmp.setMobile(mobile);
			session.setAttribute("user", tmp);

			move(request);
			System.out.println("DEST IS" + InitCommand.cmd.getView());
			DispatcherServlet.send(request, response);
			System.out.println("====MOBILE-C: CREATE_NUMBER OUT====");
			break;
		}
	}

	private void move(HttpServletRequest request) {
		new MoveCommand(request).execute();
	}
}
