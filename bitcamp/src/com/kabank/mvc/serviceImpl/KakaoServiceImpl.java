package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.daoImpl.AccountDAOImpl;
import com.kabank.mvc.domain.KakaoBean;
import com.kabank.mvc.service.KakaoService;

public class KakaoServiceImpl implements KakaoService{
	public static KakaoService getInstance() {
		return new KakaoServiceImpl();
	}
	private KakaoServiceImpl() {}
	@Override
	public void openAccount() {
		// TODO Auto-generated method stub
		
		AccountDAOImpl.getInstance().createAccount();
	}
	@Override
	public Object searchAccount() {
		// TODO Auto-generated method stub
		return AccountDAOImpl.getInstance().selectAccount();
	}
	@Override
	public KakaoBean findAccountById() {
		// TODO Auto-generated method stub
		return AccountDAOImpl.getInstance().selectAccountById();
	}
	
	
}
