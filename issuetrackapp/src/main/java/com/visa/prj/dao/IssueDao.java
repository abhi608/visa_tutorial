package com.visa.prj.dao;

import java.util.List;

import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Issue;

public interface IssueDao {
	void addEmployee(Employee emp) throws DaoException;
	List<Employee> getEmployees() throws DaoException;
	void raiseIssue(Issue issue) throws DaoException;
	List<Issue> getUnresolvedIssues() throws DaoException;
}
