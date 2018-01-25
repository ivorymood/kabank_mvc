package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.daoImpl.LottoDAOImpl;
import com.kabank.mvc.domain.LottoBean;
import com.kabank.mvc.service.LottoService;

public class LottoServiceImpl implements LottoService{
	public static LottoService getInstance() {
		return  new LottoServiceImpl();
	}
	public LottoServiceImpl() {}
	@Override
	public LottoBean findLottoById() {
		// TODO Auto-generated method stub
		return LottoDAOImpl.getInstance().selectLottoById();
	}
}
