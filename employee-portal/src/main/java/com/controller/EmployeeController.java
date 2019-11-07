package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;
import com.service.EmployeeService;
@CrossOrigin("http://127.0.0.1:4401")
@RestController
public class EmployeeController {
	//List<Employee> employees = new ArrayList<>();
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
	
}
