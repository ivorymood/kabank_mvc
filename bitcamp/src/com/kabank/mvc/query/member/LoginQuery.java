package com.kabank.mvc.query.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.domain.KakaoBean;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.AccountProps;
import com.kabank.mvc.enums.DML;
import com.kabank.mvc.enums.MemberEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.kabank.mvc.template.Conn;
import com.kabank.mvc.util.Enums.Table;

public class LoginQuery implements IQuery{
	PreparedStatement pstmt;
	public LoginQuery() {
		// TODO Auto-generated constructor stub
		try {
			pstmt = DatabaseFactory.create(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(
							DML.SELECT + " " 
							+ "id, "
							+ "pass, "
							+ "name, "
							+ "ssn, "
							+ "phone, "
							+ "email, "
							+ "profile, "
							+ "addr"
							+ " "
							+ DML.FROM + " "
							+ Table.MEMBER
							+ " "
							+ DML.WHERE
							+ " id LIKE ? AND pass LIKE ?");
			//?는 싱글쿼터 포함한 것임.
			String[] arr = InitCommand.cmd.getData().split("/");
			for(int i=0; i<arr.length; i++){
				pstmt.setString((i+1), arr[i]);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Object execute() {
		// TODO Auto-generated method stub
		MemberBean member = null;
		try {
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			member = new MemberBean();
			member.setId(rs.getString(MemberEnum.ID.toString()));
			member.setPass(rs.getString(MemberEnum.PASS.toString()));
			member.setName(rs.getString(MemberEnum.NAME.toString()));
			member.setEmail(rs.getString(MemberEnum.EMAIL.toString()));
			member.setAddr(rs.getString(MemberEnum.ADDR.toString()));
			member.setPhone(rs.getString(MemberEnum.PHONE.toString()));
			member.setSsn(rs.getString(MemberEnum.SSN.toString()));
			member.setProfile(rs.getString(MemberEnum.PROFILE.toString()));
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			Conn.close(pstmt);
		}
		return member;
	}
}
