package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.EmployeeDAO;
import com.model.Employee;
import com.service.EmployeeService;
import com.utility.ReturnObject;

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public ReturnObject addEmployee(Employee employee) {
		return employeeDAO.addEmployee(employee);
	}

	@Override
	public ReturnObject updateEmployee(Employee employee, int empID) {
		return employeeDAO.updateEmployee(employee, empID);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	public Employee getEmployee(int empID) {
		return employeeDAO.getEmployee(empID);
	}
	
	
}
