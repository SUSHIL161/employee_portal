package com.utility;

import com.model.Employee;

public class ReturnObject {

	private boolean success;
	private Employee employee;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public ReturnObject() {
		
	}
}
