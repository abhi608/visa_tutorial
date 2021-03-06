package com.visa.prj.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewTask {
	public static void main(String[] args) {
		String report = "Ramesh sold 500 products of Iphone each costing 98000";
		Map<String, Integer> m1 = new HashMap<>();
		Map<String, List<String>> m2 = new HashMap<>();
		for(String str : report.split(" ")) {
			if(str.matches("[0-9]+")) {
				if(m1.containsKey("numbers")) {
					m1.put("numbers", m1.get("numbers")+1);
				}
				else {
					m1.put("numbers", 1);
				}
				
				if(m2.containsKey("numbers2")) {
					m2.get("numbers2").add(str);
				}
				else {
					m2.put("numbers2", new ArrayList<>());
					m2.get("numbers2").add(str);
				}
			}
			else {
				if(m1.containsKey("words")) {
					m1.put("words", m1.get("words")+1);
				}
				else {
					m1.put("words", 1);
				}
				
				if(m2.containsKey("words2")) {
					m2.get("words2").add(str);
				}
				else {
					m2.put("words2", new ArrayList<>());
					m2.get("words2").add(str);
				}
			}
		}
		
		m1.forEach((k, v) -> {
			System.out.println(k + " : " + v);
		});
		
		m2.forEach((k, v) -> {
			System.out.println(k + " : " + v);
		});
	}
}
