package com.kabank.mvc.enums;

public enum MemberEnum {
	ID, PASS, NAME, SSN, PHONE, EMAIL, ADDR, PROFILE, COUNT, 
	PROPERTIES{@Override
		public String toString() {
			// TODO Auto-generated method stub
			return ID+", "+PASS+", "+NAME+", "+SSN+", "+PHONE+", "+EMAIL+", "+PROFILE+", "+ADDR;
		}
	},
	LOGIN{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "SELECT ID, PASS, NAME, SSN, PHONE, EMAIL, ADDR, PROFILE FROM Member "
					+"WHERE id LIKE '$' AND pass LIKE '@'";
		}	//쿼리문에서 아스타XX 항상 다 뭘 불러오는지 스키마를 좀 써라
	}
	
}
