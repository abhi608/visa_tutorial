package com.visa.prj.dao;

import com.visa.prj.entity.User;

public interface UserDao {
	void register(User user) throws PersistenceException;
	User login(String email, String pwd) throws FetchException;
	
}
