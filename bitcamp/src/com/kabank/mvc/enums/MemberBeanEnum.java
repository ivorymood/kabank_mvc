package com.kabank.mvc.enums;

public enum MemberBeanEnum {
	ID("id"),
	PASS("pass"),
	NAME("name"),
	SSN("ssn"),
	PHONE("phone"),
	EMAIL("email"),
	ADDR("addr"),
	PROFILE("profile"),
	COUNT("count");
	public final String value;
	private MemberBeanEnum(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	
}
