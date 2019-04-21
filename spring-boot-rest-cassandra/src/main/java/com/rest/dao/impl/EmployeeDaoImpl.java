package com.rest.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.dao.EmployeeDao;
import com.rest.entity.Employee;
import com.rest.util.MyCassandraTemplate;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private MyCassandraTemplate myCassandraTemplate;

	@Override
	public void createEmployee(Employee employee) {
		myCassandraTemplate.create(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		myCassandraTemplate.update(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		myCassandraTemplate.deleteById(id, Employee.class);
	}

	@Override
	public Employee getEmployee(int id) {
		return myCassandraTemplate.findById(id, Employee.class);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return myCassandraTemplate.findAll(Employee.class);
	}
}
