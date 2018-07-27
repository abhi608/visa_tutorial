package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.visa.prj.entity.Vehicle;
import com.visa.prj.util.JPAUtil;

public class VehicleDaoJpaImpl implements VehicleDao {

	@Override
	public void addVehicle(Vehicle v) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
			em.persist(v);
		em.getTransaction().commit();
	}

	@Override
	public List<String> getRegNos() {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("SELECT v.registrationNumber FROM Vehicle v");
		return query.getResultList();
	}

}
