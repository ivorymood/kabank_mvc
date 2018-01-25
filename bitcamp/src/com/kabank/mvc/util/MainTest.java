package com.kabank.mvc.util;

import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.AccountProps;
import com.kabank.mvc.enums.DML;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.MemberProps;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.factory.PropertiesFactory;
import com.kabank.mvc.factory.SqlFactory;
import com.kabank.mvc.serviceImpl.MemberServiceImpl;
import com.kabank.mvc.util.Enums.Table;

public class MainTest {
	public static void main(String[] args) {
		
		/*System.out.println(SqlFactory.update("Member", "pass", "change", "id", "aaaa"));
		System.out.println(SqlFactory.select("*", TnameEnum.MEMBER.getValue()));
		System.out.println(SqlFactory.login("*", TnameEnum.MEMBER.getValue(), "aaa", "bbb"));
		System.out.println(SqlFactory.delete(TnameEnum.MEMBER.getValue(), "id"));
		System.out.println(SqlFactory.select("*", "tab"));*/
		StringBuffer buffer = new StringBuffer("010-");
		for(int i=0; i<8; i++) {
			int tmp = (int)(Math.random()*10)+0;
			buffer.append(tmp);
		}
		buffer.replace(8, 8, "-");
		System.out.println(buffer);
		System.out.println(DML.INSERT.toString() + " " 
				+ DML.INTO.toString() + " "
				+ TnameEnum.MOBILE.getValue()+"("
				+ "customer_num, phone, reg_date, id) "
				+ DML.VALUES.toString()+"("
				+ "cutomer_num.nextval, "
				+ "'"+buffer.toString() +"', "
				+ "sysdate, "
				+ "ddddddddd"
				+")");
		
	}
}
