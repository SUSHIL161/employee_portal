package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Employee;

@Service
public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public boolean addEmployee(Employee employee);
}
