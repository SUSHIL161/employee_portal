package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;
import com.service.EmployeeService;
//@CrossOrigin("http://127.0.0.1:4401")
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getAllEmployees")
	
	public List<Employee> getAllEmployees() {
		try {
			return employeeService.getAllEmployees();

		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@PostMapping("/addEmployee")
	public boolean addEmployee(@RequestBody Employee employee) {		
		return employeeService.addEmployee(employee);
	}
	
	@PutMapping("/updateEmployee/{empID}")
	public boolean updateEmployee(@RequestBody Employee employee, @PathVariable int empID) {
		return employeeService.updateEmployee(employee, empID);
	}
	
	@GetMapping("/getEmployee/{empID}")
	public Employee getEmployee(@PathVariable int empID) {
		return employeeService.getEmployee(empID);
	}
}
