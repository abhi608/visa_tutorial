package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Product;
import com.visa.prj.util.JPAUtil;

public class CustomerDaoJpaImpl implements CustomerDao {

	@Override
	public Customer getCustomer(String email) throws DaoException {
		EntityManager em = JPAUtil.getEntityManager();
		return em.find(Customer.class, email);
	}

}
