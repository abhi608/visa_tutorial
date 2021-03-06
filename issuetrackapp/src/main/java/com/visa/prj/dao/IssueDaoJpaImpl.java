package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Issue;
import com.visa.prj.util.JPAUtil;

public class IssueDaoJpaImpl implements IssueDao {

	@Override
	public void addEmployee(Employee emp) throws DaoException {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
	}

	@Override
	public List<Employee> getEmployees() throws DaoException {
		EntityManager em = JPAUtil.getEntityManager();
		/*
		 * JPQL = Java Persistence Query language
		 * JPQL uses Class name and attributes of class and not table and columns
		 * JPQL is case-sensitive, SQL is not case-sensitive
		 */
		TypedQuery<Employee> query = em.createQuery("Select e from Employee e", Employee.class);
		return query.getResultList();
	}

	@Override
	public void raiseIssue(Issue issue) throws DaoException {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(issue);
		em.getTransaction().commit();
	}

	@Override
	public List<Issue> getUnresolvedIssues() throws DaoException {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Issue> query = em.createQuery("Select i from Issue i where i.status=0", Issue.class);
		return query.getResultList();
	}

}
