package com.kabank.mvc.decorate;

public abstract class QueryDecorator implements IQuery{
	protected IQuery query;
	public QueryDecorator(IQuery query) {
		// TODO Auto-generated constructor stub
		this.query = query;
	}
	public Object execute() {
		return query.execute();
	}
}
