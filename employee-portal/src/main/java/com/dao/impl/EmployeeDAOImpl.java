package com.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.dao.EmployeeDAO;
import com.model.Employee;
import com.utility.ReturnObject;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	Map<Integer, Employee> employees;
	
	ReturnObject returnObject;
	public EmployeeDAOImpl() {
		employees = new HashMap<>();
		returnObject = new ReturnObject();
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
	public ReturnObject addEmployee(Employee employee) {
		int empID = employee.hashCode();
		if(employees.containsKey(empID) || !validateEmployee(employee)) {
			returnObject.setSuccess(false);
		} else {
			employee.setEmpID(empID);
			employees.put(empID, employee);
			returnObject.setSuccess(true);
			returnObject.setEmployee(employee);
		}
		return returnObject;
	}

	@Override
	public ReturnObject updateEmployee(Employee employee, int empID) {
		if(!validateEmployee(employee) || !employees.containsKey(empID)) {
			returnObject.setSuccess(false);
		} else {
			employees.put(empID, employee);
			returnObject.setSuccess(true);
			returnObject.setEmployee(employee);
		}
		return returnObject;
	}

	private boolean validateEmployee(Employee employee) {
		return  employee == null ? false :
			employee.getFirstName() != null && employee.getFirstName().trim().length() > 0 &&
			employee.getLastName() != null && employee.getLastName().trim().length() > 0 &&
			employee.getGender() != null && employee.getGender().trim().length() > 0 &&
			employee.getDateOfBirth() != null &&
			employee.getDepartment() != null && employee.getDepartment().length() > 0;
 	}
}
