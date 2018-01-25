package com.kabank.mvc.daoImpl;

import com.kabank.mvc.dao.MobileDAO;
import com.kabank.mvc.decorate.ExecuteQuery;
import com.kabank.mvc.decorate.ExecuteUpdate;
import com.kabank.mvc.query.common.InsertQuery;
import com.kabank.mvc.query.common.SelectIfExistQuery;
import com.kabank.mvc.query.mobile.SelectMobileByIdQuery;

public class MobileDAOImpl implements MobileDAO {
public static MobileDAO getInstance() {
	return new MobileDAOImpl();
}
private MobileDAOImpl() {}
@Override
public void insertNumber() {
	// TODO Auto-generated method stub
	new ExecuteUpdate(new InsertQuery()).execute();
}
@Override
public Object selectNumber() {
	// TODO Auto-generated method stub
	return new ExecuteQuery(new SelectIfExistQuery()).execute();
}
@Override
public Object selectMobile() {
	// TODO Auto-generated method stub
	return new ExecuteQuery(new SelectMobileByIdQuery()).execute();
}

}
