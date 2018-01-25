package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.dao.CommonDAO;
import com.kabank.mvc.daoImpl.CommonDAOImpl;
import com.kabank.mvc.service.CommonService;

public class CommonServiceImpl implements CommonService{
CommonDAO dao;
public CommonServiceImpl() {
	dao = new CommonDAOImpl();
}
	@Override
	public String countTable() {
		//컨트롤러는 DAO호출X 서비스를 호출한다 왜? 보안때문에
		return dao.selectTableCount();
	}

}
