package com.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.model.Employee;
import com.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	List<Employee> employees = new ArrayList<>();
	@Override
	public List<Employee> getAllEmployees() {

		Employee e1 = new Employee();
		e1.setFirstName("e1");
		employees.add(e1);
		Employee e2 = new Employee();
		e2.setFirstName("e2");
		employees.add(e2);
		Employee e3 = new Employee();
		e3.setFirstName("e3");
		employees.add(e3);
		employees.sort((employee1,employee2) -> {
			return employee1.getFirstName().compareTo(employee2.getFirstName());
		});
		
		return employees;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		if(!validateEmployee(employee)) {
			return false;
		}
		return employees.add(employee);
	}

	private boolean validateEmployee(Employee employee) {
		return  
			(employee.getFirstName() != null && employee.getFirstName().trim().length() > 0) &&
			(employee.getLastName() != null && employee.getLastName().trim().length() > 0) && 
			(employee.getDateOfBirth() != null) &&
			employee.getDepartment() != null && employee.getDepartment().length() > 0;
 	}
	
}
