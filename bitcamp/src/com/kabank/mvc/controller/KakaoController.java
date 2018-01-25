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
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.command.SelectIfExistCommand;
import com.kabank.mvc.domain.KakaoBean;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.factory.SqlFactory;
import com.kabank.mvc.serviceImpl.KakaoServiceImpl;
import com.kabank.mvc.util.DispatcherServlet;

@WebServlet("/kakao.do")
public class KakaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("===========BANK 서블릿 내부로 들어옴===========");
		HttpSession session = request.getSession();
		
		new InitCommand(request).execute();
		
		switch(InitCommand.cmd.getAction()) {
		
		case OPEN_ACCOUNT:
			System.out.println("====BANK-C: OPEN IN====");
			
			boolean exist = true;
			while(exist) {
				new SelectIfExistCommand(request).execute();
				Object account = KakaoServiceImpl.getInstance().searchAccount();
				if(account==null) {
					System.out.println("CreateAccountCommand : 검색 결과 이미 있는 계좌번호 없음");
					new InsertCommand(request).execute();
					exist = false;
				}else {
					System.out.println("계좌번호 다시 만들기");
				}
			}
			KakaoServiceImpl.getInstance().openAccount();
			
			MemberBean member = (MemberBean)session.getAttribute("user");
			InitCommand.cmd.setData(member.getId());
			KakaoBean kakao = KakaoServiceImpl.getInstance().findAccountById();
			
			member.setKakao(kakao);
			session.setAttribute("user", member);
			move(request);
			System.out.println("DEST IS" + InitCommand.cmd.getView());
			DispatcherServlet.send(request, response);
			System.out.println("====BANK-C: OPEN OUT====");
			break;
		case MOVE:
			System.out.println("====BANK-C: MOVE IN====");
			move(request);
			DispatcherServlet.send(request, response);
			System.out.println("====BANK-C: MOVE OUT====");
			break;
		
		}
	
	}
	private void move(HttpServletRequest request) {
		new MoveCommand(request).execute();
	}
}
