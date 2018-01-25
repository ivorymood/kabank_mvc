package com.kabank.mvc.iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class ParamsIterator {
	public static Map<?,?> execute(HttpServletRequest request){
		Map<String, String> result = new HashMap<>();
		Map<String, String[]> map = request.getParameterMap(); //jsp책 76p.
		Set<Entry<String, String[]>> set = map.entrySet();
		Iterator<Map.Entry<String, String[]>> it = set.iterator();
		String params[] = new String[set.size()];
		int i = 0;
		
		while(it.hasNext()) {
			Map.Entry<String, String[]> e = it.next();
			params[i]=e.getKey();
			i++;
		}
		
		for(i=0; i<params.length; i++) {
			if(map.get(params[i]).length==1){
				result.put(params[i], map.get(params[i])[0]);		//체크박스 아닌거
			}else {
				String temp = "";
				for(int j=0; j<map.get(params[i]).length; j++) {	//체크박스 인거
					temp += map.get(params[i])[j] + ",";			//결과값을 그냥 한줄로 받아옴 --> 1대1 대응을 위해
				}
				result.put(params[i], temp);
			}														//그럼 화면에서 받아올 값이 체크박스이건 아니건 다 처리 가능.
		}
		System.out.println("cmd 존재 여부 : " + map.containsKey("cmd"));
		return result;
	}
}
