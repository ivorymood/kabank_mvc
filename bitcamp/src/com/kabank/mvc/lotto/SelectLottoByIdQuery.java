package com.kabank.mvc.lotto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.domain.LottoBean;
import com.kabank.mvc.enums.LottoProps;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.kabank.mvc.factory.SqlFactory;

public class SelectLottoByIdQuery implements IQuery{
PreparedStatement pstmt;
	public SelectLottoByIdQuery() {
	// TODO Auto-generated constructor stub
	try {
		pstmt = DatabaseFactory.create(Vendor.ORACLE)
				.getConnection()
				.prepareStatement(
						SqlFactory.selectById(
								"*", 
								TnameEnum.LOTTO.getValue(), 
								InitCommand.cmd.getData()));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	@Override
	public Object execute() {
		// TODO Auto-generated method stub
		LottoBean lotto = new LottoBean();
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				lotto.setLottoNum(rs.getString(LottoProps.LOTTO_NUM.toString()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lotto;
	}

}
