package com.kabank.mvc.service;

import com.kabank.mvc.domain.MemberBean;

public interface MemberService {
	void joinMember();
	public MemberBean login();
	public void changePass(MemberBean member);
	public void deleteMember();
	
}
