package com.visa.prj.web;

import java.beans.PropertyEditorSupport;

import com.visa.prj.entity.Address;

public class AddressPropertyEditor extends PropertyEditorSupport {

	private Address address;	
	
	@Override
	public String getAsText() {
		// TODO Auto-generated method stub
		if(address == null) {
			return "number;street;city";
		}
		return address.getNumber() + ";" + address.getStreet() + ";" + address.getCity();
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		String[] data = text.split(";");
		address = new Address();
		address.setNumber(data[0]);
		address.setStreet(data[1]);
		address.setCity(data[2]);
		setValue(address);
	}
	
}