package com.kabank.mvc.query.common;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;

public class InsertQuery implements IQuery{
	PreparedStatement pstmt;
	public InsertQuery() {
		// TODO Auto-generated constructor stub
	try {
		System.out.println("===InsertQuery에 들어옴===");
		pstmt = DatabaseFactory.create(Vendor.ORACLE)
				.getConnection()
				.prepareStatement(
						InitCommand.cmd.getSql());
		System.out.println("==intsertQuery에서 받은 sql: "+ InitCommand.cmd.getSql());
	} catch (Exception e) {
		// TODO Auto-generated catch block
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
