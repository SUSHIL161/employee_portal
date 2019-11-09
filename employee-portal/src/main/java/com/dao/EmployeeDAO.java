package com.dao;

import java.util.List;

import com.model.Employee;

public interface EmployeeDAO {

	public boolean addEmployee(Employee employee);
	
	public boolean updateEmployee(Employee employee, int empID);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployee(int empID);
	
}
