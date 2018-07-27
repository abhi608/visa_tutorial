package com.visa.prj.dao;

import com.visa.prj.entity.Mobile;

public interface MobileDao { // by default, all methods are public and abstract in an Interface
	int MAX = 100; // constant(not a keyword) ==> public static final int MAX = 100; | final evaluates to constant
	void addMobile(Mobile mobile);
}
