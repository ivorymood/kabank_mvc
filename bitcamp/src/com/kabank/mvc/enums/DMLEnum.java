package com.kabank.mvc.enums;

public enum DMLEnum {
	
	COUNT{
		@Override
		public String toString() {
			return "SELECT COUNT(*) AS count FROM ";
		}
	},
	SELECT{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "SELECT $ FROM @";
		}
	},
	SELECTBYID{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "SELECT $ FROM @ WHERE id = '&' order by customer_num";
		}
	},
	LOGIN{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return " WHERE id LIKE '$' AND pass LIKE '@'";
		}
	},
	INSERT{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "INSERT INTO @($) VALUES (&)";
		}
	},
	VALUES{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return " VALUES ";
		}
	},
	UPDATE{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "UPDATE $ SET @ WHERE &";
		}
	},
	CNV{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "$ = '^'";
		}
	},
	DELETE{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "DELETE FROM $ WHERE id = '&'";
		}
	}
	//where 분리작업 할 것.
}
