package com.kabank.mvc.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.decorate.ExecuteQuery;
import com.kabank.mvc.decorate.ExecuteUpdate;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.MemberBeanEnum;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.kabank.mvc.factory.SqlFactory;
import com.kabank.mvc.query.member.DeleteMemberQuery;
import com.kabank.mvc.query.member.InsertMemberQuery;
import com.kabank.mvc.query.member.LoginQuery;
import com.kabank.mvc.query.member.UpdateQuery;

public class MemberDAOImpl implements MemberDAO {
	
	public static MemberDAO getInstance() {return new MemberDAOImpl();}
	private MemberDAOImpl() {}
	//팩토리 패턴이므로 로직을 감춘다 (private으로)
	
	@Override
	public void insertMember() {
		System.out.println("====MEMBER-d: JOIN IN===");
		new ExecuteUpdate(new InsertMemberQuery()).execute();
		System.out.println("====MEMBER-D: JOIN IN===");
	}
	@Override
	public MemberBean login() {
		System.out.println("====MEMBER-D: LOGIN IN====");
		
		System.out.println("====MEMBER-D: LOGIN OUT====");
		return (MemberBean) new ExecuteQuery(new LoginQuery()).execute();
		//리턴으로 하는게 빠름!! 이게 데코레이션 패턴. executeQuery의 생성자 속에 LoginQuery를 넣어야됨.
	}
	@Override
	public void updatePass(MemberBean member) {
		System.out.println("====MEMBER-D: UPDATE_PASS IN====");
		new ExecuteUpdate(new UpdateQuery()).execute();
		System.out.println("====MEMBER-D: UPDATE_PASS OUT====");
		
	}
	@Override
	public void delete() {
		System.out.println("====MEMBER-D: DELETE IN====");
		new ExecuteUpdate(new DeleteMemberQuery()).execute();
		System.out.println("====MEMBER-D: DELETE OUT====");
	}
}
