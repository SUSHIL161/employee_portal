package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Employee;

@Service
public interface EmployeeService {
	
	public boolean addEmployee(Employee employee);
	
	public boolean updateEmployee(Employee employee, int empID);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployee(int empID);
}
