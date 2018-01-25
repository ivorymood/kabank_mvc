package com.kabank.mvc.enums;

public enum Action {
	MOVE, LOGIN, JOIN, SEARCH, UPDATE, CREATE, CHANGE_PASS, DELETE,
	LOGOUT, OPEN_ACCOUNT, SELECT_ACCOUNT, CREATE_NUMBER, MYPAGE,
	VIEW{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "/WEB-INF/view/";
		}
	},
	EXTENSION{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return ".jsp";
		}
	},
	SEPARATOR{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "/";
		}
	}
	
}
