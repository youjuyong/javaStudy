package com.CollectionsStudy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class IteratorEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList();
		
		for(int i = 0; i < 10; i++) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("1test", i);
			list.add(map);
		}
		
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
	}

}
