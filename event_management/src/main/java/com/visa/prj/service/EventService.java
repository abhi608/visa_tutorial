package com.visa.prj.service;

import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.EventDao;
import com.visa.prj.dao.RegistrationDao;
import com.visa.prj.dao.UserDao;
import com.visa.prj.entity.Event;
import com.visa.prj.entity.Registration;
import com.visa.prj.entity.User;


@Service
@Transactional
public class EventService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private EventDao eventDao;
	
	@Autowired
	private RegistrationDao registrationDao;
	
	public void addEevent(Event event) {
		eventDao.addEevent(event);
	}

	public List<Event> getOpenEvents() {
		return eventDao.getOpenEvents();
	}

	public List<Event> getClosedEvents() {
		return eventDao.getClosedEvents();
	}
	
	public void insertUser(User user) {
		userDao.addUser(user);
	}
	
	public List<User> getUsers(){
		return userDao.getUsers();
	}
	
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	public void register(String email, String evt) {
		// TODO Auto-generated method stub
		User user = userDao.getUserByEmail(email);
		Event event = eventDao.getEventById(Integer.parseInt(evt));
		Registration reg = new Registration();
		reg.setRegistrationDate(new Date());
		reg.setEvent(event);
		reg.setUser(user);
		registrationDao.register(reg);
	}
}
