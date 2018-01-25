package com.kabank.mvc.enums;

public enum DDLEnum {
	CREATE_TABLE_MEMBER{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "CREATE TABLE Member("
			+"id VARCHAR2(20) PRIMARY KEY,"
			+"pass VARCHAR2(20),"
			+"name VARCHAR2(20),"
			+"ssn VARCHAR2(20),"
			+"phone VARCHAR2(20),"
			+"email VARCHAR2(20),"
			+"profile VARCHAR2(20),"
			+"addr VARCHAR2(20)"
			+")";
		}
	},
	CREATE_TABLE_ATTEND{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "CREATE TABLE Attend("
			+ "seq NUMBER PRIMARY KEY, "
			+ "weak VARCHAR2(10), "
			+ "status VARCHAR2(10)"
			+ "id VARCHAR2(20))";
		}
	},
	CREATE_TABLE_KAKAO{
		@Override
		public String toString() {
			return "CREATE TABLE Kakao("
			+ "customer_num int PRIMARY KEY,"
			+ "account_num VARCHAR2(20) not null,"
			+ "money VARCHAR2(20) default 0,"
			+ "id VARCHAR2(20),"
			+ "FOREIGN KEY (id) REFERENCES Member(id) ON DELETE CASCADE)";
		};
	},
	CREATE_TABLE_MOBILE{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "CREATE TABLE Mobile("
					+"customer_num int PRIMARY KEY,"
					+"phone_num VARCHAR2(20) not null,"
					+"reg_date DATE not null,"
					+"id VARCHAR2(20),"
					+"FOREIGN KEY (id) REFERENCES Member(id) ON DELETE CASCADE)";
		}
	}
}
