package com.kabank.mvc.command;

import javax.servlet.http.HttpServletRequest;

import com.kabank.mvc.enums.AccountProps;
import com.kabank.mvc.enums.DML;
import com.kabank.mvc.enums.MobileProps;
import com.kabank.mvc.enums.TnameEnum;

public class SelectIfExistCommand implements IOrder{
	String servletPath;
	StringBuffer buffer;
	public SelectIfExistCommand(HttpServletRequest request) {
		// TODO Auto-generated constructor stub
		servletPath = request.getServletPath().split("/")[1].split("\\.")[0];
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		switch(servletPath) {
		case "kakao":
			System.out.println("===SelectIfExistCommand: /kakao.do===");
			buffer = new StringBuffer();
			for(int i=0; i<12; i++) {
				int tmp = (int)(Math.random()*10)+0;
				buffer.append(tmp);
			}
			buffer.replace(4, 4, "-").replace(9, 9, "-");
			System.out.println("SelectIfExsitCommand의 계좌번호 : "+buffer);
			InitCommand.cmd.setColumn(AccountProps.ACCOUNT_NUM.toString());
			InitCommand.cmd.setData(buffer.toString());
			
			InitCommand.cmd.setSql(
					DML.SELECT + " " 
					+ AccountProps.ACCOUNT_NUM
					+ " "
					+ DML.FROM
					+ " "
					+ TnameEnum.KAKAO);
			
			break;
		case "mobile":
			System.out.println("===SelectIfExistCommand: /telecom.do===");
			buffer = new StringBuffer("010-");
			for(int i=0; i<8; i++) {
				int tmp = (int)(Math.random()*10)+0;
				buffer.append(tmp);
			}
			buffer.replace(8, 8, "-");
			System.out.println("SelectIfExsitCommand의 전화번호 : "+buffer);
			InitCommand.cmd.setColumn(MobileProps.PHONE_NUM.toString());
			InitCommand.cmd.setData(buffer.toString());
			
			InitCommand.cmd.setSql(
					DML.SELECT + " " 
					+ MobileProps.PHONE_NUM
					+ " "
					+ DML.FROM
					+ " "
					+ TnameEnum.MOBILE
					);
			break;
		}
	}

}
