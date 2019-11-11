package com.dao;

import java.util.List;

import com.model.Employee;
import com.utility.ReturnObject;

public interface EmployeeDAO {

	public ReturnObject addEmployee(Employee employee);
	
	public ReturnObject updateEmployee(Employee employee, int empID);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployee(int empID);
	
}
