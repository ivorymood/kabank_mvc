package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.enums.PathEnum;
import com.kabank.mvc.service.AdminService;
import com.kabank.mvc.serviceImpl.AdminServiceImpl;

@WebServlet({"/admin.do"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("===========ADMIN 서블릿 내부로 들어옴===========");
		HttpSession session = request.getSession();
		InitCommand init = new InitCommand(request);
		init.execute();
		String dir ="";
		String dest = "";
		switch(InitCommand.cmd.getAction()) {
			case CREATE:
				System.out.println("====ADMIN-C: CREATE IN===");
				AdminServiceImpl.getInstance().makeTable(
						request.getParameter("select_table"));
				
				dir = "admin";
				 dest = "main";
				
				System.out.println("====ADMIN-C: CREATE OUT===");
				break;
		}
		
		request
		.getRequestDispatcher(PathEnum.VIEW.getValue()+dir+PathEnum.SEPARATOR.getValue()+dest+PathEnum.EXTENSION.getValue())
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
