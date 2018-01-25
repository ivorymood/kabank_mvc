package com.kabank.mvc.util;

import java.util.HashMap;

public class Enums {
	public enum MemberColumn {
		ID, NAME, SSN, EMAIL, PHONE, PASS, ADDR
	}
	public enum AttendColumn{
		WEAK, STATUS, ID
	}
	public enum Table{
		MEMBER, ATTEND, ADMIN
	}
	public enum DML{
		INSERT, INTO, VALUES, SELECT, FROM 
	}
	public static String getTableName(int index) {
		HashMap<String, String> map = new HashMap<String, String>();
		for(Enums.Table c : Enums.Table.values()) {
			String tmp = c +"";
			map.put(tmp, tmp);
		}
		return map.get(index);
	}
	public static String getMemberColumn() {
		String tmp = "";
		for(Enums.MemberColumn c : Enums.MemberColumn.values()) {
			if(c.ordinal()==6) {
				tmp += c;
			}else {
				tmp += c + ", ";
			}
			
		}
		return tmp;
	}
	public static String getBlanks(int count) {
		String blanks="'%s'";
		String res = "";
		for(int i=0; i<count; i++) {
			if(i != count-1) {
				res += blanks + ", ";
			}else {
				res += blanks;
			}
		}
		return res;
	}

}
