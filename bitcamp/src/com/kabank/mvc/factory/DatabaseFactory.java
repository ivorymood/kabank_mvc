package com.kabank.mvc.factory;

import com.kabank.mvc.enums.Vendor;

public class DatabaseFactory {
	public static IDatabase create(Vendor vendor) {
		//static을 붙이면 인스턴스를 만들필요 없이 해당 메소드에 접근할 수 있다 -> 싱글톤 유지
		IDatabase db = null;
		String flag = "";
		switch (vendor) {
		case ORACLE:
			db = new Oracle();
			break;

		default:
			break;
		}		
		return db;
	}
}
