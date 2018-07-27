package com.visa.prj.entity;

public class Mobile extends Project {
	private String connectivity;

	public Mobile() {
	}

	public Mobile(int id, String name, double price, String connectivity) {
		super(id, name, price);
		this.connectivity = connectivity;
	}

	public String getConnectivity() {
		return connectivity;
	}

	public void setConnectivity(String connectivity) {
		this.connectivity = connectivity;
	}

	@Override
	public boolean isExpensive() {
		if(this.connectivity.equals("3G") && this.getPrice() > 10000) {
			return true;
		} else if(this.connectivity.equals("4G") && this.getPrice() > 20000) {
			return true;
		}
		return false;
	} 
	
}
