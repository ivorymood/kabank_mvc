package com.kabank.mvc.query.member;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;

public class UpdateQuery implements IQuery{
	PreparedStatement pstmt;
	public UpdateQuery() {
		// TODO Auto-generated constructor stub
		try {
			pstmt = DatabaseFactory.create(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(
							InitCommand.cmd.getSql());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	@Override
	public Object execute() {
		// TODO Auto-generated method stub
		int numUpd;
		try {
			numUpd = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "1";
	}

}
