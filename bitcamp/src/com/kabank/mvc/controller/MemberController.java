package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.DeleteCommand;
import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.InsertCommand;
import com.kabank.mvc.command.LoginCommand;
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.command.UpdateCommand;
import com.kabank.mvc.domain.FoodBean;
import com.kabank.mvc.domain.KakaoBean;
import com.kabank.mvc.domain.LottoBean;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.domain.MobileBean;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.factory.SqlFactory;
import com.kabank.mvc.serviceImpl.FoodServiceImpl;
import com.kabank.mvc.serviceImpl.KakaoServiceImpl;
import com.kabank.mvc.serviceImpl.LottoServiceImpl;
import com.kabank.mvc.serviceImpl.MemberServiceImpl;
import com.kabank.mvc.serviceImpl.MobileServiceImpl;
import com.kabank.mvc.util.DispatcherServlet;
import com.sun.javafx.collections.MappingChange.Map;

@WebServlet({"/user.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
								//직렬화 시켜주는 것. L은 롱타입
	
	@SuppressWarnings("unused")
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("===========MEMBER 서블릿 내부로 들어옴===========");
		HttpSession session = request.getSession();
		
		InitCommand init = new InitCommand(request);
		init.execute();
		/*Command cmd = null;*/
		MemberBean param = new MemberBean();
		MemberBean myMember = new MemberBean();
		switch(InitCommand.cmd.getAction()) {
		case MYPAGE:
			break;
		case LOGOUT: 
			System.out.println("====MEMBER-C: LOGOUT IN====");
			session.invalidate();
			move(request);
			DispatcherServlet.send(request, response);
			System.out.println("====MEMBER-C: LOGOUT OUT====");
			break;
		case DELETE:
			System.out.println("====MEMBER-C: DELETE IN====");
			new DeleteCommand(request).execute();
			MemberServiceImpl.getInstance().deleteMember();
			session.invalidate();
			move(request);
			
			System.out.println("DEST IS" + InitCommand.cmd.getView());
			DispatcherServlet.send(request, response);
			System.out.println("====MEMBER-C: DELETE OUT====");
			break;
		case CHANGE_PASS:
			System.out.println("====MEMBER-C: CHANGE_PASS IN====");
			new UpdateCommand(request).execute();
			MemberServiceImpl.getInstance().changePass(
					(MemberBean)session.getAttribute("user"));
			move(request);
			
			System.out.println("DEST IS" + InitCommand.cmd.getView());
			DispatcherServlet.send(request, response);
			System.out.println("====MEMBER-C: CHANGE_PASS OUT====");
			break;
		case MOVE : 
			System.out.println("====MEMBER-C: MOVE IN====");
			move(request);	//alt + shift + m : 리 팩토링 (보안떄문에 다시 감싸는것!)
			
			System.out.println("DEST IS " + InitCommand.cmd.getView());
			DispatcherServlet.send(request, response);
			System.out.println("====MEMBER-C: MOVE OUT====");
			break;
		case LOGIN:
			System.out.println("====MEMBER-C: LOGIN IN====");
			login(request, session);
			
			System.out.println("DEST IS " + InitCommand.cmd.getView());
			DispatcherServlet.send(request,response);	
			System.out.println("====MEMBER-C: LOGIN OUT====");
			break;
		
		case JOIN:
			System.out.println("====MEMBER-C: JOIN IN===");
			new InsertCommand(request).execute();
			MemberServiceImpl.getInstance().joinMember();
			move(request);
			DispatcherServlet.send(request, response);
			System.out.println("====MEMBER-C: JOIN OUT====");
			break;
		}
		
		
	}


	private void move(HttpServletRequest request) {
		new MoveCommand(request).execute();
	}

	private void login(HttpServletRequest request, HttpSession session)
			throws ServletException, IOException {
		new LoginCommand(request).execute();
		/*Command cmd = new Command();
		@SuppressWarnings("unchecked")
		Map<String, String> paramMap =(Map<String, String>) new InitCommand(request).paramMap();*/
		MemberBean member = MemberServiceImpl.getInstance().login();
		
		/*cmd.setMember(new MemberBean());
		cmd.getMember().setId(paramMap.get("id"));
		cmd.getMember().setPass(paramMap.get("pass"));*/
		/*rm = MemberServiceImpl.getInstance().login(cmd);*/
		
		/*if(!rm.isSuccess) {
			InitCommand.cmd.setDir("user");
			InitCommand.cmd.setPage("login");
		}else {
			session.setAttribute("user", rm.getMember());
			myPage(request);
			InitCommand.cmd.setDir("user");
			InitCommand.cmd.setPage("mypage");
		}*/
		
		if(member==null) {
			InitCommand.cmd.setDir("user");
			InitCommand.cmd.setPage("login");
			System.out.println("member == null");
		}else {
			session.setAttribute("user", member);
			myPage(request);
		}
		move(request);
	}
	private void myPage(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		MemberBean member = (MemberBean)session.getAttribute("user");
		//기본값은 무조건 있을것이다. 그래서 null 체크가 필요없다. BUT 추가되는 객체 account, phone은 null일수 있다. 
		
		InitCommand.cmd.setData(member.getId());
		MobileBean mobile = (MobileBean)MobileServiceImpl.getInstance().findMobileById();
		/*LottoBean lotto = LottoServiceImpl.getInstance().findLottoById();
		FoodBean food = FoodServiceImpl.getInstance().findFoodById();*/
		KakaoBean kakao = KakaoServiceImpl.getInstance().findAccountById();
		
		if(mobile != null) {member.setMobile(mobile);};
		/*if(lotto != null) {member.setLotto(lotto);};
		if(food != null) {member.setFood(food);};*/
		if(kakao != null) {member.setKakao(kakao);};
		session.setAttribute("user", member);
		System.out.println("===계좌있음~~===");
		
	}

}
