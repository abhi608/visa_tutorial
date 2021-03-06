package com.visa.prj.entity;

public class Tv extends Project {
	private String screenType;

	public Tv() {
	}

	public Tv(int id, String name, double price, String screenType) {
		super(id, name, price);
		this.screenType = screenType;
	}

	public String getScreenType() {
		return screenType;
	}

	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}
	
	@Override
	public boolean isExpensive() {
//		System.out.println("TEST" + this.getPrice() + this.getScreenType());
		if(this.getScreenType().equals("CRT") && this.getPrice() > 5000) {
			return true;
		} else if(this.getScreenType().equals("LED") && this.getPrice() > 40000) {
			return true;
		}
		return false;
	}
	
}
