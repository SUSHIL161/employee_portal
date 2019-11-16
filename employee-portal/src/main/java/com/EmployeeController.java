package com;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.dao.EmployeeDAO;
import com.dao.impl.EmployeeDAOImpl;
import com.model.Employee;
import com.service.EmployeeService;
import com.service.impl.EmployeeServiceImpl;

//@RunWith (MockitoJUnitRunner.class)
public class EmployeeController {
	
	@Mock
	private EmployeeDAO employeeDAO;// = new EmployeeDAOImpl();
	
	//@InjectMocks
	private EmployeeService employeeService;// = new EmployeeServiceImpl();

	@Before
	public void init() {
        MockitoAnnotations.initMocks(this);
        employeeService = new EmployeeServiceImpl();

	}
	@Test
	public void test() {
		Employee e1 = new Employee();
		e1.setEmpID(1);
		when(employeeDAO.getEmployee(Mockito.anyInt())).thenReturn(e1);
		System.out.println("emp " + employeeDAO);
		Employee e2 = employeeService.getEmployee(1);
		assertEquals(e1, e2);
	}
}
