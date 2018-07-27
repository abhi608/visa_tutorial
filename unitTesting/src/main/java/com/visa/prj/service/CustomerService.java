package com.visa.prj.service;

import com.visa.prj.dao.FetchException;
import com.visa.prj.dao.PersistenceException;
import com.visa.prj.dao.UserDao;
import com.visa.prj.entity.User;

public class CustomerService {
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public boolean register(User user) {
		try {
			userDao.register(user);
			return true;
		} catch (PersistenceException e) {
//			e.printStackTrace();
			return false;
		}
	}
	
	public User login(String email, String pwd) {
		User user = null;
		try {
			user = userDao.login(email, pwd);
		} catch (FetchException e) {
			e.printStackTrace();
		}
		return user;
	}
}