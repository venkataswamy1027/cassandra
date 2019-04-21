package com.rest.dao;

import java.util.List;

import com.rest.entity.Employee;

public interface EmployeeDao {

	void createEmployee(Employee employee);

	Employee getEmployee(int id);
	
	void updateEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	void deleteEmployee(int id);
}
