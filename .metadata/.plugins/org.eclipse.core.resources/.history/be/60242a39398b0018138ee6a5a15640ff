package com.visa.prj.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import com.visa.prj.dao.FetchException;
import com.visa.prj.dao.PersistenceException;
import com.visa.prj.dao.UserDao;
import com.visa.prj.entity.User;

public class CustomerServiceTest {
	
	@Mock
	private UserDao userDao = Mockito.mock(UserDao.class);
	
	private CustomerService customerService;

	@Before
	public void setUp() throws Exception {
		customerService = new CustomerService();
		customerService.setUserDao(userDao);
	}

	@After
	public void tearDown() throws Exception {
		customerService = null;
	}

	@Test
	public void testRegister() {
		User user = new User("banu@gmail.com", "secret124");
		try {
			doNothing().when(userDao).register(user);
			assertEquals(true, customerService.register(user));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		User u = new User("banu@gmail.com", "secret124");
		try {
			doThrow(new PersistenceException()).when(userDao).register(u);
			assertEquals(false, customerService.register(u));
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testLogin() {
		User user = new User("banu@gmail.com", "secret124");
		try {
			when(userDao.login("banu@gmail.com", "secret124")).thenReturn(user);
			assertEquals(user, customerService.login("banu@gmail.com", "secret124"));
		} catch (FetchException e) {
			e.printStackTrace();
		}
		
		try {
			when(userDao.login("banu@gmail.com", "ssdf")).thenThrow(new FetchException());
			assertEquals(null, customerService.login("banu@gmail.com", "ssdf"));
		} catch (FetchException e) {
			e.printStackTrace();
		}

	}

}
