package com.kabank.mvc.query.common;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.domain.KakaoBean;
import com.kabank.mvc.enums.AccountProps;
import com.kabank.mvc.enums.DML;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;

public class SelectIfExistQuery implements IQuery{
	PreparedStatement pstmt;
	public SelectIfExistQuery() {
		// TODO Auto-generated constructor stub
		try {
			pstmt = DatabaseFactory.create(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(
							InitCommand.cmd.getSql());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Object execute() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		Object exist = null;
		try {
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			String tmp = rs.getString(InitCommand.cmd.getColumn());
			list.add(tmp);
		}
		for(String s : list) {
			if(s.equalsIgnoreCase(InitCommand.cmd.getData())) {
				exist = "not null";
				break;
			}
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return exist;
	}
}
