package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.daoImpl.MobileDAOImpl;
import com.kabank.mvc.service.MobileService;

public class MobileServiceImpl implements MobileService{
public static MobileService getInstance() {
	return new MobileServiceImpl();
}
private MobileServiceImpl() {}
@Override
public void createNumber() {
	// TODO Auto-generated method stub
	MobileDAOImpl.getInstance().insertNumber();
}
@Override
public Object searchNumber() {
	// TODO Auto-generated method stub
	return MobileDAOImpl.getInstance().selectNumber();
}
@Override
public Object findMobileById() {
	// TODO Auto-generated method stub
	return MobileDAOImpl.getInstance().selectMobile();
}
}
