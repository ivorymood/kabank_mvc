package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.daoImpl.FoodDAOImpl;
import com.kabank.mvc.domain.FoodBean;
import com.kabank.mvc.service.FoodService;

public class FoodServiceImpl implements FoodService {
	public static FoodService getInstance() {
		return  new FoodServiceImpl();
	}
	public FoodServiceImpl() {}
	@Override
	public FoodBean findFoodById() {
		// TODO Auto-generated method stub
		return FoodDAOImpl.getInstance().selectFoodById();
	}
}
