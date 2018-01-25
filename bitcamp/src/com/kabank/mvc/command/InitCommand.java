package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.factory.ActionFactory;
import com.kabank.mvc.factory.SqlFactory;
import com.kabank.mvc.iterator.ParamsIterator;

public class InitCommand implements IOrder{
	public static Command cmd;
	//모든 녀석이 다 쓰는 것은 static으로 주는 것이 낫다
	//그렇다고 static을 남용하면 시스템이 뻗어버림.
	//InitCommand의 cmd인지, UpdateCommand의 cmd인지 구분하기 위해서
	//외부에서 써먹을때는 InitCommand.cmd 로 쓴다.
	Map<?,?> map;
	public InitCommand(HttpServletRequest request) {
		cmd = new Command();
		map = ParamsIterator.execute(request);
	}
	public void execute() {
		String o = String.valueOf(map.get("cmd"));
		if(o.equals("null")) {	//파라미터에서 넘어올때는 null이 스트링값으로 넘어온다. 네트워크상에서는 전부 스트링값으로 전달된다.
			cmd.setAction(ActionFactory.create("move"));
		}
		cmd.setAction(ActionFactory.create(o));
		
		System.out.println("InitCommand의 action"+cmd.getAction());
	}
	public Map<?,?> paramMap(){
		return map;
	}
}
