package com.kabank.mvc.decorate;

public class ExecuteQuery extends QueryDecorator{
	//디폴트 생성자를 못만들도록 강제하는 것
	//extends했는데 에러뜬다? ==> 상속받은 것이 추상클래스다
	//상속, 강제를 할 필요가 있어서 queryDecorator의 메소드를 만듦.
	public ExecuteQuery(IQuery query) {
		super(query);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Object execute() {
		// TODO Auto-generated method stub
		return super.execute();
	}
	
}
