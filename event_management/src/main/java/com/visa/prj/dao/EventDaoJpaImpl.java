package com.visa.prj.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Event;

@Repository
public class EventDaoJpaImpl implements EventDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addEevent(Event event) {
		// TODO Auto-generated method stub
		em.persist(event);
	}

	@Override
	public List<Event> getOpenEvents() {
		// TODO Auto-generated method stub
		TypedQuery<Event> query = em.createQuery("From Event e WHERE e.eventDate >= :today", Event.class);
		query.setParameter("today", new Date(), TemporalType.TIMESTAMP);
		return query.getResultList();
	}

	@Override
	public List<Event> getClosedEvents() {
		// TODO Auto-generated method stub
		TypedQuery<Event> query = em.createQuery("From Event e WHERE e.eventDate <= :today", Event.class);
		query.setParameter("today", new Date(), TemporalType.TIMESTAMP);
		return query.getResultList();
	}

	@Override
	public Event getEventById(int id) {
		
		return em.find(Event.class, id);
	}

}
