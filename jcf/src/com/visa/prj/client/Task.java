package com.visa.prj.client;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task {
	public static void main(String[] args) {
		String sentence = "I came I saw U came I left";
		Set<String> unique = new HashSet<>();
		Set<String> dups = new HashSet<>();
//		List<String> st = new ArrayList<>();
//		List<String> 
		
		for(String str: sentence.split(" ")) {
			if(unique.contains(str)) {
				dups.add(str);
				unique.remove(str);
			}
			else {
				unique.add(str);
			}
		}
			
		unique.removeAll(dups);
		
		for(String s: unique) {
			System.out.println(s);
		}
		System.out.println("--------------------");
		for(String s: dups) {
			System.out.println(s);
		}
		
	}
}
