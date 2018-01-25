package com.kabank.mvc.daoImpl;

import com.kabank.mvc.dao.AccountDAO;
import com.kabank.mvc.decorate.ExecuteQuery;
import com.kabank.mvc.decorate.ExecuteUpdate;
import com.kabank.mvc.domain.KakaoBean;
import com.kabank.mvc.query.common.InsertQuery;
import com.kabank.mvc.query.common.SelectIfExistQuery;
import com.kabank.mvc.query.kakao.LoginIncludeAccountQuery;
import com.kabank.mvc.query.kakao.SelectKakaoByIdQuery;

public class AccountDAOImpl implements AccountDAO{
	public static AccountDAO getInstance() {
		return new AccountDAOImpl();
	}
	private AccountDAOImpl() {}
	@Override
	public void createAccount() {
		new ExecuteUpdate(new InsertQuery()).execute();
	}
	@Override
	public Object selectAccount() {
		return new ExecuteQuery(new SelectIfExistQuery()).execute();
	}
	@Override
	public KakaoBean selectAccountById() {
		return (KakaoBean)new ExecuteQuery(new SelectKakaoByIdQuery()).execute();
		//쿼리 바꿔야됨.
	}
}
