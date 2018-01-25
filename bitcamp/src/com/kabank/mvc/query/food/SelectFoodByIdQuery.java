package com.kabank.mvc.query.food;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.domain.FoodBean;
import com.kabank.mvc.enums.FoodProps;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.kabank.mvc.factory.SqlFactory;

public class SelectFoodByIdQuery implements IQuery{
PreparedStatement pstmt;
	public SelectFoodByIdQuery() {
	// TODO Auto-generated constructor stub
	try {
		pstmt = DatabaseFactory.create(Vendor.ORACLE)
				.getConnection()
				.prepareStatement(
						SqlFactory.selectById(
								"*", 
								TnameEnum.FOOD.getValue(), 
								InitCommand.cmd.getData()));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	@Override
	public Object execute() {
		FoodBean food = new FoodBean();
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				food.setCheckbox(rs.getString(FoodProps.CHECKBOX.toString()));
				food.setCount(rs.getString(FoodProps.COUNT.toString()));
				food.setMenu(rs.getString(FoodProps.MENU.toString()));
				food.setPrice(rs.getString(FoodProps.PRICE.toString()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return food;
	}

}
