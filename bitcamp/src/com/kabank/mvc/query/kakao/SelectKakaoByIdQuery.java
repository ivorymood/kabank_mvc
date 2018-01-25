package com.kabank.mvc.query.kakao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.domain.KakaoBean;
import com.kabank.mvc.enums.AccountProps;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.kabank.mvc.factory.SqlFactory;

public class SelectKakaoByIdQuery implements IQuery{
PreparedStatement pstmt;
	public SelectKakaoByIdQuery() {
	// TODO Auto-generated constructor stub
	try {
		pstmt = DatabaseFactory.create(Vendor.ORACLE)
				.getConnection()
				.prepareStatement(
						SqlFactory.selectById(
								"*", 
								TnameEnum.KAKAO.getValue(), 
								InitCommand.cmd.getData()));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	@Override
	public Object execute() {
		KakaoBean kakao = new KakaoBean();
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				kakao.setAccountNum(rs.getString(AccountProps.ACCOUNT_NUM.toString()));
				kakao.setMoney(rs.getString(AccountProps.MONEY.toString()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kakao;
	}

}
