package com.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.dao.EmployeeDao;
import com.rest.entity.Employee;
import com.rest.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void createEmployee(Employee employee) {
		employeeDao.createEmployee(employee);
	}

	@Override
	public Employee getEmployee(int id) {
		return employeeDao.getEmployee(id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

}
