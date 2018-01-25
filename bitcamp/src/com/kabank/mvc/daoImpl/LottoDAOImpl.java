package com.kabank.mvc.daoImpl;

import com.kabank.mvc.dao.LottoDAO;
import com.kabank.mvc.decorate.ExecuteQuery;
import com.kabank.mvc.domain.LottoBean;
import com.kabank.mvc.lotto.SelectLottoByIdQuery;

public class LottoDAOImpl implements LottoDAO{
	public static LottoDAO getInstance() {
		return new LottoDAOImpl();
	}
	private LottoDAOImpl() {}
	@Override
	public LottoBean selectLottoById() {
		// TODO Auto-generated method stub
		return (LottoBean)new ExecuteQuery(new SelectLottoByIdQuery()).execute();
	}
}
