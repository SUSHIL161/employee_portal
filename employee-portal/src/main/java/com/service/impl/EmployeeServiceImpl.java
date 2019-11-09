package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.EmployeeDAO;
import com.model.Employee;
import com.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public boolean addEmployee(Employee employee) {
		return employeeDAO.addEmployee(employee);
	}

	@Override
	public boolean updateEmployee(Employee employee, int empID) {
		return employeeDAO.updateEmployee(employee, empID);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	public Employee get(int empID) {
		return employeeDAO.get(empID);
	}
	
	
}
