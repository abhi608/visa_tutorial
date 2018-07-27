package com.visa.prj.entity;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String name;
	private List<String> languages = new ArrayList<String>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getLanguages() {
		return languages;
	}
	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}
	
	
}
