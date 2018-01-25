package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.daoImpl.AdminDAOImpl;
import com.kabank.mvc.service.AdminService;

public class AdminServiceImpl implements AdminService{

	public static AdminService getInstance() {
	return new AdminServiceImpl();
}
private AdminServiceImpl() {}
	@Override
	public void makeTable(String tname) {
		// TODO Auto-generated method stub
		AdminDAOImpl.getInstance().createTable(tname);
	}

}
