package com.kabank.mvc.query.kakao;

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
import com.kabank.mvc.util.Enums.Table;

public class LoginIncludeAccountQuery implements IQuery{
	PreparedStatement pstmt;
	public LoginIncludeAccountQuery() {
		// TODO Auto-generated constructor stub
		try {
			pstmt = DatabaseFactory.create(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(
							DML.SELECT + " " 
							+ "k.customer_num,"
							+ "m.id,"
							+ "m.pass,"
							+ "m.name,"
							+ "m.ssn,"
							+ "m.phone,"
							+ "m.email,"
							+ "m.profile,"
							+ "m.addr,"
							+ "k.account_num,"
							+ "k.money"
							+ " "
							+ DML.FROM + " "
							+ Table.MEMBER
							+ " m, kakao k "
							+ DML.WHERE
							+ " m.id = k.id AND m.id LIKE ?"
							+ " order by k.customer_num");
			//?는 싱글쿼터 포함한 것임.
				pstmt.setString(1, InitCommand.cmd.getData());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Object execute() {
		// TODO Auto-generated method stub
		MemberBean member = null;
		KakaoBean kakao = null;
		try {
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			member = new MemberBean();
			kakao = new KakaoBean();
			member.setId(rs.getString(MemberEnum.ID.toString()));
			member.setPass(rs.getString(MemberEnum.PASS.toString()));
			member.setName(rs.getString(MemberEnum.NAME.toString()));
			member.setEmail(rs.getString(MemberEnum.EMAIL.toString()));
			member.setAddr(rs.getString(MemberEnum.ADDR.toString()));
			member.setPhone(rs.getString(MemberEnum.PHONE.toString()));
			member.setSsn(rs.getString(MemberEnum.SSN.toString()));
			member.setProfile(rs.getString(MemberEnum.PROFILE.toString()));
			kakao.setAccountNum(rs.getString(AccountProps.ACCOUNT_NUM.toString()));
			kakao.setMoney(rs.getString(AccountProps.MONEY.toString()));
			kakao.setCustomerNum(rs.getString(AccountProps.CUSTOMER_NUM.toString()));
			member.setKakao(kakao);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return member;
	}
}
