package com.visa.prj.client;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
		Map<String, Integer> sales = new HashMap<>();
		sales.put("Java", 100);
		sales.put("Oracle", 983);
		sales.put("javaScript", 200);
		if(sales.containsKey("Java")) {
			System.out.println("Sales of Java books: " + sales.get("Java"));
		}
		
		int count = sales.get("Java");
		count++;
		sales.put("Java",  count);
		
		Set<String> keys = sales.keySet();
		for(String key : keys) {
			System.out.println(key + " : " + sales.get(key));
		}
		
		sales.forEach((k, v) -> {
			System.out.println(k + " : " + v);
		});
	}
}
