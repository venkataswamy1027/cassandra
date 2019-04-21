package com.rest.service;

import java.util.List;

import com.rest.entity.Employee;

public interface EmployeeService {

	void createEmployee(Employee employee);
	
	Employee getEmployee(int id);
	
	void updateEmployee(Employee employee);
	
	void deleteEmployee(int id);
	
	List<Employee> getAllEmployees();

}
