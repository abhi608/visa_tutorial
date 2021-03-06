package com.visa.prj.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("mobile")
//@Table(name="new_mobile")
public class Mobile extends Item {
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
	
}
