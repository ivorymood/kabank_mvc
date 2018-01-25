package com.kabank.mvc.daoImpl;

import com.kabank.mvc.dao.FoodDAO;
import com.kabank.mvc.decorate.ExecuteQuery;
import com.kabank.mvc.domain.FoodBean;
import com.kabank.mvc.query.food.SelectFoodByIdQuery;

public class FoodDAOImpl implements FoodDAO{
	public static FoodDAO getInstance() {
		return new FoodDAOImpl();
	}
	private FoodDAOImpl() {}
	@Override
	public FoodBean selectFoodById() {
		// TODO Auto-generated method stub
		return (FoodBean)new ExecuteQuery(new SelectFoodByIdQuery()).execute();
	}
}
