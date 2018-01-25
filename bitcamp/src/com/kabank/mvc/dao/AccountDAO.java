package com.kabank.mvc.dao;

import com.kabank.mvc.domain.KakaoBean;

public interface AccountDAO {

	public void createAccount();
	public Object selectAccount();
	public KakaoBean selectAccountById();
}
