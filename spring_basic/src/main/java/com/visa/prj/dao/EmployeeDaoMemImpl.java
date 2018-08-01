package com.visa.prj.dao;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoMemImpl implements EmployeeDao {

	@Override
	public void addEmployee() {
		System.out.println("Employee stored using Mem!!!");
	}

}
