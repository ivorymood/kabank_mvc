package com.kabank.mvc.enums;

public enum TnameEnum {
	MEMBER("member"), 
	ATTEND("attend"), 
	KAKAO("kakao"),
	MOBILE("mobile"),
	TNAME("TNAME"),
	FOOD("food"),
	LOTTO("lotto");
	public final String value;
	private TnameEnum(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	/*TNAMES{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return MEMBER+","+ATTEND;
		}
	}*/
	
}
