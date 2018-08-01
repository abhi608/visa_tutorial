package com.visa.prj.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Registration;

@Repository
public class RegistrationDaoJpaImpl implements RegistrationDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void register(Registration reg) {
		// TODO Auto-generated method stub
		em.persist(reg);
	}

}
