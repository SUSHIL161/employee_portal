package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Employee;
import com.utility.ReturnObject;

@Service
public interface EmployeeService {
	
	public ReturnObject addEmployee(Employee employee);
	
	public ReturnObject updateEmployee(Employee employee, int empID);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployee(int empID);
}
