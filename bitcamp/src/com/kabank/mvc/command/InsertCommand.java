package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.AccountProps;
import com.kabank.mvc.enums.DDLEnum;
import com.kabank.mvc.enums.DML;
import com.kabank.mvc.enums.MemberEnum;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.factory.SqlFactory;
import com.kabank.mvc.iterator.ParamsIterator;
import com.kabank.mvc.serviceImpl.KakaoServiceImpl;

public class InsertCommand implements IOrder {
	Map<?,?> map;
	MemberBean member;
	HttpSession session;
	String servletPath;
	StringBuffer buffer;
	public InsertCommand(HttpServletRequest request){
		map = ParamsIterator.execute(request);
		member = new MemberBean();
		session = request.getSession();
		servletPath = request.getServletPath().split("/")[1].split("\\.")[0];
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		switch(servletPath) {
		case "user": 
			System.out.println("===InserCommand: /user.do===");
			String id = (String) map.get("join_id");
			String pass = (String) map.get("join_pass");
			String name = (String) map.get("join_name");
			String ssn = (String) map.get("join_first_ssn") + (String) map.get("join_second_ssn");
			String phone = (String) map.get("join_phone_agency") + (String) map.get("join_first_num")
			+ (String) map.get("join_second_num") + (String) map.get("join_third_num");
			String email = (String) map.get("join_first_email") + (String) map.get("join_email_select");
			String profile = "";
			String addr = (String) map.get("join_first_addr") + (String) map.get("join_second_addr") 
			+ (String) map.get("join_third_addr") + (String) map.get("join_fourth_addr");
			
			String res = "'"+id+"','"+pass+"','"+name+"','"+ssn+"','"+phone+"','"+email+"','"+profile+"','"+addr+"'";
			
			InitCommand.cmd.setSql(
					SqlFactory.insert(
					TnameEnum.MEMBER.getValue(),
					MemberEnum.PROPERTIES.toString(),
					res));
			System.out.println("JoinCommand에서 sql : "+InitCommand.cmd.getSql());
			break;
		
		case "kakao":
			System.out.println("===InserCommand: /kakao.do===");
			String sql = DML.INSERT + " " 
					+ DML.INTO + " " 
					+ TnameEnum.KAKAO + "("
					+ AccountProps.CUSTOMER_NUM+", "
					+ AccountProps.ACCOUNT_NUM +", " 
					+ AccountProps.MONEY+", "
					+ AccountProps.ID + ")"
					+ " "
					+ DML.VALUES + "("
					+ "customer_num.nextval, "
					+ "'"+ InitCommand.cmd.getData()+ "', "
					+ "0, "
					+ "'"+ ((MemberBean)session.getAttribute("user")).getId()+"'"
					+ ")";
			InitCommand.cmd.setSql(sql);
			break;
		case "mobile":
			System.out.println("===InserCommand: /telecom.do===");
			InitCommand.cmd.setSql(
					"insert into Mobile("
					+"customer_num, phone_num, reg_date, id) "
					+"values(" 
					+"customer_num.nextval, "
					+ "'"+ InitCommand.cmd.getData()+ "', "
					+ "sysdate, "
					+ "'"+((MemberBean)session.getAttribute("user")).getId()+"')");
			
			/*insert into telecom(
					customer_num, phone, reg_date, id) 
					values(
					customer_num.nextval, 
					'test', 
					sysdate, 
					'vvvv');*/
			System.out.println("InsertCommand의 sql : " +InitCommand.cmd.getSql());
			
			break;
		}
		
		
		
	}

}
