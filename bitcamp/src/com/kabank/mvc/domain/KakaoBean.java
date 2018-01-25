package com.kabank.mvc.domain;

import lombok.Data;

@Data
public class KakaoBean {
	private String customerNum, accountNum, money, id;

	@Override
	public String toString() {
		return "KakaoBean [고객번호= " + customerNum + ", 계좌번호= " + accountNum + ", 잔액= " + money + ", id= "
				+ id + "]";
	}
	

}
