package com.visa.prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.EmployeeDao;

@Service
public class EmployeeService {
	
	@Autowired //will create setters for this | will connect to the class implementing this interface
	@Qualifier("employeeDaoMemImpl") // since there are two implementations, we need to tell which to use
	private EmployeeDao employeeDao; // Bytecode Instrumentation
	
	public void doTask() {
		employeeDao.addEmployee();
	}
}
