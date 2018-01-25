package com.kabank.mvc.daoImpl;

import com.kabank.mvc.dao.AttendDAO;

public class AttendDAOImpl implements AttendDAO{
	public static AttendDAO getInstance() {
		return new AttendDAOImpl();
	}
	private AttendDAOImpl() {}
}
