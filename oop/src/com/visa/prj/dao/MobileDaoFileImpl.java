package com.visa.prj.dao;

import com.visa.prj.entity.Mobile;

public class MobileDaoFileImpl implements MobileDao {

	@Override
	public void addMobile(Mobile mobile) {
		// TODO Auto-generated method stub
		System.out.println(mobile.getName() + " added to file!!!");
	}

}
