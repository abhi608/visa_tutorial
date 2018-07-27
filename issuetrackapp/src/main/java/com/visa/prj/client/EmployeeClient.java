package com.visa.prj.client;

import java.util.List;

import javax.management.openmbean.KeyAlreadyExistsException;

import com.visa.prj.dao.IssueDao;
import com.visa.prj.dao.IssueDaoJpaImpl;
import com.visa.prj.entity.Employee;

public class EmployeeClient {
	public static void main(String[] args) {
		while(true) {
			printOptions();
			int choice = KeyboardUtil.getInt("Select Option:");
			if(choice == 1) {
				String employeeFirstName = KeyboardUtil.getString("Enter employee's first name:");
				String employeeLastName = KeyboardUtil.getString("Enter employee's last name:");
				String employeeEmail = KeyboardUtil.getString("Enter employee's email:");
				IssueDao dao = new IssueDaoJpaImpl();
				Employee emp = new Employee(employeeEmail, employeeFirstName, employeeLastName);
				
				try {
					dao.addEmployee(emp);
					System.out.println("Employee created successfully!!!");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if(choice == 2) {
				IssueDao dao = new IssueDaoJpaImpl();
				try {
					List<Employee> employees = dao.getEmployees();
					for(Employee ep : employees) {
						System.out.println(ep);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if(choice == 3) {
				System.exit(0);
			}
		}
		
	}
	
	private static void printOptions() {
		System.out.println("1. Add employee");
		System.out.println("2. List employees");
		System.out.println("3. Exit");
		System.out.println("Select [1/2/3]");
	}
}
