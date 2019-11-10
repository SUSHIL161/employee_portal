package com.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.dao.EmployeeDAO;
import com.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	Map<Integer, Employee> employees;
	
	public EmployeeDAOImpl() {
		employees = new HashMap<>();
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = employees.values().stream().collect(Collectors.toList());
		employeeList.sort((first,second) -> first.getFirstName().compareTo(second.getFirstName()));
		return employeeList;
	}

	@Override
	public Employee getEmployee(int empID) {
		return employees.get(empID);
	}

	@Override
	public boolean addEmployee(Employee employee) {
		int empID = employee.hashCode();
		if(employees.containsKey(empID) || !validateEmployee(employee)) {
			return false;
		}
		employee.setEmpID(empID);
		employees.put(empID, employee);
		return true;
	}

	@Override
	public boolean updateEmployee(Employee employee, int empID) {
		if(!validateEmployee(employee) || !employees.containsKey(empID)) {
			return false;
		}
		employees.put(empID, employee);
		return true;
	}

	private boolean validateEmployee(Employee employee) {
		return  employee == null ? false :
			(employee.getFirstName() != null && employee.getFirstName().trim().length() > 0) &&
			(employee.getLastName() != null && employee.getLastName().trim().length() > 0) && 
			(employee.getDateOfBirth() != null) &&
			employee.getDepartment() != null && employee.getDepartment().length() > 0;
 	}
}
