package com.kabank.mvc.factory;

import com.kabank.mvc.enums.DMLEnum;

public class SqlFactory {
	
	public static String update(String tname, String setColumn, String setValue,
			String whereColumn, String whereValue) {
		StringBuffer buffer = new StringBuffer(DMLEnum.UPDATE.toString());
		
		buffer.replace(buffer.indexOf("$"), buffer.indexOf("$")+1, tname);
		buffer.replace(buffer.indexOf("@"), buffer.indexOf("@")+1, DMLEnum.CNV.toString())
		.replace(buffer.indexOf("$"), buffer.indexOf("$")+1, setColumn)
		.replace(buffer.indexOf("^"), buffer.indexOf("^")+1, setValue);
		buffer.replace(buffer.indexOf("&"), buffer.indexOf("&")+1, DMLEnum.CNV.toString())
		.replace(buffer.indexOf("$"), buffer.indexOf("$")+1, whereColumn)
		.replace(buffer.indexOf("^"), buffer.indexOf("^")+1, whereValue);
		return buffer.toString();
	}
	public static String select(String columns, String tname) {
		StringBuffer buffer = new StringBuffer(DMLEnum.SELECT.toString());
		
		buffer.replace(buffer.indexOf("$"), buffer.indexOf("$")+1, columns)
		.replace(buffer.indexOf("@"), buffer.indexOf("@")+1, tname);
		
		return buffer.toString();
	}
	public static String login(String columns, String tname, String idValue, String passValue) {
		StringBuffer buffer = new StringBuffer(SqlFactory.select(columns, tname))
				.append(DMLEnum.LOGIN.toString());
		buffer.replace(buffer.indexOf("$"), buffer.indexOf("$")+1, idValue)
		.replace(buffer.indexOf("@"), buffer.indexOf("@")+1, passValue);
		return buffer.toString();
	}
	public static String delete(String tname, String idValue) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer(DMLEnum.DELETE.toString());
		buffer.replace(buffer.indexOf("$"), buffer.indexOf("$")+1, tname)
		.replace(buffer.indexOf("&"), buffer.indexOf("&")+1, idValue);
		return buffer.toString();
		//"DROP TABLE $ WHERE id = '&'"
	}
	public static String insert(String tname, String attNames, String values) {
		StringBuffer buffer = new StringBuffer(DMLEnum.INSERT.toString());
		
		buffer.replace(buffer.indexOf("@"), buffer.indexOf("@")+1, tname)
		.replace(buffer.indexOf("$"), buffer.indexOf("$")+1, attNames)
		.replace(buffer.indexOf("&"), buffer.indexOf("&")+1, values);
		return buffer.toString();
	}
	public static String selectById(String columns, String tname, String idValue) {
		StringBuffer buffer = new StringBuffer(DMLEnum.SELECTBYID.toString());
		buffer.replace(buffer.indexOf("$"), buffer.indexOf("$")+1, columns)
		.replace(buffer.indexOf("@"), buffer.indexOf("@")+1, tname)
		.replace(buffer.indexOf("&"), buffer.indexOf("&")+1, idValue);
		return buffer.toString();
		//"SELECT $ FROM @ WHERE id = '&'"
	}
}
