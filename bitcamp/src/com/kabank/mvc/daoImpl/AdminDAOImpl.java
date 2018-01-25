package com.kabank.mvc.daoImpl;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.dao.AdminDAO;
import com.kabank.mvc.enums.DDLEnum;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.kabank.mvc.factory.SqlFactory;

public class AdminDAOImpl implements AdminDAO {
	
	public static AdminDAO getInstance() {
		return new AdminDAOImpl();
	}
	private AdminDAOImpl() {}
	@Override
	public void createTable(String tname) {
		// TODO Auto-generated method stub
		System.out.println("====ADMIN-d: CREATETABLE IN===");
		try {
			String sql ="";
			Statement stmt = DatabaseFactory.create(Vendor.ORACLE)
					.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(SqlFactory.select("*", "tab"));
			List<String> list = new ArrayList<String>();
			while(rs.next()) {
				list.add(rs.getString(TnameEnum.TNAME.getValue()));
			}
			boolean exist = false;
			for(String l : list) {
				if(l.equalsIgnoreCase(tname)) {
					exist = true;
					break;
				}
			}
			if(!exist) {
				switch(tname){
				case "member":	
					sql = DDLEnum.CREATE_TABLE_MEMBER.toString();
					break;
				case "attend": 
					sql = DDLEnum.CREATE_TABLE_ATTEND.toString();
					break;
				case "kakao":
					sql = DDLEnum.CREATE_TABLE_KAKAO.toString();
					break;
				case "mobile":
					sql = DDLEnum.CREATE_TABLE_MOBILE.toString();
					break;
				}
				System.out.println("생성sql : " +sql);
				stmt.executeQuery(sql);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("====ADMIN-d: CREATETABLE OUT===");
	}
}
