package com.kabank.mvc.enums;

public enum MiniEnum {
	OPEN_BRACKET("("),
	CLOSE_BRACKET(")"),
	ASTER("*"),
	PERCENT_S("'%s'"),
	COMMA(","),
	COMMMA_PERCENT_S(", '%s'"),
	QUESTION_MARK("?");
	public final String value;
	private MiniEnum(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	
}
