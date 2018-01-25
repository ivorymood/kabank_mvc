package com.kabank.mvc.dao;

import java.util.List;

import com.kabank.mvc.domain.MemberBean;

public interface MemberDAO {
	public void insertMember();
	public MemberBean login();
	public void updatePass(MemberBean member);
	public void delete();
}
