package com.kabank.mvc.query.mobile;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.domain.MobileBean;
import com.kabank.mvc.enums.MobileProps;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.kabank.mvc.factory.SqlFactory;

public class SelectMobileByIdQuery implements IQuery {
	PreparedStatement pstmt;
	public SelectMobileByIdQuery() {
		try {
			pstmt = DatabaseFactory.create(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(
							SqlFactory.selectById(
									"*", 
									TnameEnum.MOBILE.getValue(), 
									InitCommand.cmd.getData()));
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	@Override
	public Object execute() {
		MobileBean mobile = null;
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				mobile = new MobileBean();
				mobile.setPhoneNum(rs.getString(MobileProps.PHONE_NUM.toString()));
				mobile.setRegDate(rs.getString(MobileProps.REG_DATE.toString()));
			}
			System.out.println("DB에서 받아온 전화번호: "+ mobile.getPhoneNum());
			System.out.println("DB에서 받아온 regdate: "+mobile.getRegDate());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mobile;
	}

}
