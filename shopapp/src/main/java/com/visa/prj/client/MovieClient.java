package com.visa.prj.client;

import javax.persistence.EntityManager;

import com.visa.prj.entity.Actor;
import com.visa.prj.entity.Movie;
import com.visa.prj.util.JPAUtil;

public class MovieClient {
	public static void main(String[] args) {
		Movie m1 = new Movie();
		m1.setName("Mr. amnd Mrs. Smith");
		
		Movie m2 = new Movie();
		m2.setName("Ocean's Eleven");
		
		Actor a1 = new Actor();
		a1.setName("Brad Pitt");
		
		Actor a2 = new Actor();
		a2.setName("Angelina Jolie");
		
		Actor a3 = new Actor();
		a3.setName("George Clooney");
		
		m1.getActors().add(a1);
		m1.getActors().add(a2);
		
		m2.getActors().add(a1);
		m2.getActors().add(a3);
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
			em.persist(m1);
			em.persist(m2);
		em.getTransaction().commit();
	}
}	
