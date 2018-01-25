package com.kabank.mvc.daoImpl;

import com.kabank.mvc.dao.CommonDAO;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.MemberEnum;
import com.kabank.mvc.enums.OracleEnum;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;

import java.sql.*;

public class CommonDAOImpl implements CommonDAO{
	
	@Override
	public String selectTableCount() {
		
		String count = "";
		try {
			ResultSet rs = DatabaseFactory.create(Vendor.ORACLE).getConnection()
					.createStatement()
					.executeQuery(DMLEnum.COUNT.toString()+TnameEnum.MEMBER);
			while(rs.next()) {
				count = rs.getString(MemberEnum.COUNT+"");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	
}
