package com;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dao.EmployeeDAO;
import com.dao.impl.EmployeeDAOImpl;
import com.service.EmployeeService;
import com.service.impl.EmployeeServiceImpl;
import com.utility.ReturnObject;

@SpringBootApplication
public class EmployeeRunner {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(EmployeeRunner.class);
		application.setDefaultProperties(Collections.singletonMap("server.port", 7075));
		application.run(args);
		System.out.println(EmployeeRunner.class.getName());
	}
	
	@Bean
	public EmployeeService getService() {
		return new EmployeeServiceImpl();
	}
	
	@Bean
	public EmployeeDAO getEmployeeDAO() {
		return new EmployeeDAOImpl();
	}
	
}
