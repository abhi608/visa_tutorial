package com.visa.prj.client;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.visa.prj.entity.Employee;

public class EmployeeClient {
	public static void main(String[] args) {
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		
		e1.setName("George");
		e2.setName("Amy");
		
		e1.setLanguages(Arrays.asList("Java", "JS", "Python", "Go", "C#"));
		e2.setLanguages(Arrays.asList("Python", "Lisp", "C"));
		
		List<Employee> emps = Arrays.asList(e1, e2);
		
		emps.stream().map(e -> e.getLanguages()).forEach(System.out::println);
		
		// print all the skills
		Set<String> skills = emps.stream().map(e -> e.getLanguages())
		.flatMap(Collection::stream)
		.map(String::toUpperCase)
		.collect(Collectors.toSet());
		
		System.out.print(skills);
	}
}
