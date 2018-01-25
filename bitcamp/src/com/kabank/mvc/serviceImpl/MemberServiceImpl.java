package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.daoImpl.MemberDAOImpl;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.MemberService;

public class MemberServiceImpl implements MemberService{
	public static MemberService getInstance() {
		return new MemberServiceImpl();
	}
	private MemberServiceImpl() {}
	
	@Override
	public void joinMember() {
		// TODO Auto-generated method stub
		MemberDAOImpl.getInstance().insertMember();
	}
	@Override
	public MemberBean login() {
		// TODO Auto-generated method stub
		return MemberDAOImpl.getInstance().login();
	}
	@Override
	public void changePass(MemberBean member) {
		// TODO Auto-generated method stub
		MemberDAOImpl.getInstance().updatePass(member);
	}
	@Override
	public void deleteMember() {
		// TODO Auto-generated method stub
		MemberDAOImpl.getInstance().delete(); 
	}
}
