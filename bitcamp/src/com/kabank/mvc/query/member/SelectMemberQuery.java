package com.kabank.mvc.query.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.MemberBeanEnum;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.kabank.mvc.factory.SqlFactory;

public class SelectMemberQuery implements IQuery {
	PreparedStatement pstmt;
public SelectMemberQuery() {
	// TODO Auto-generated constructor stub
	try {
		pstmt = DatabaseFactory.create(Vendor.ORACLE).getConnection()
				.prepareStatement(SqlFactory.select("*", TnameEnum.MEMBER.getValue()));
	}catch(Exception e) {
		e.printStackTrace();
	}
}
	@Override
	public Object execute() {
		// TODO Auto-generated method stub
		List<MemberBean> list = new ArrayList<>();
		try {
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				MemberBean member = new MemberBean();
				member.setId(rs.getString(MemberBeanEnum.ID.getValue()));
				member.setPass(rs.getString(MemberBeanEnum.PASS.getValue()));
				list.add(member);
			}	//하나씩 하나씩 받아서 더하고 더하자
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
