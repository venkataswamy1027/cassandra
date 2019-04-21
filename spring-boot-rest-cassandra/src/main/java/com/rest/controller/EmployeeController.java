package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entity.Employee;
import com.rest.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void create(@RequestBody Employee employee) {
		System.out.println("create method executed.");
		employeeService.createEmployee(employee);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Employee> findAll() {
		System.out.println("findAll method executed.");
		return employeeService.getAllEmployees();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Employee findById(@PathVariable("id") int id) {
		System.out.println("findById method executed.");
		return employeeService.getEmployee(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		System.out.println("delete method executed.");
		employeeService.deleteEmployee(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody Employee employee) {
		System.out.println("update method executed.");
		employeeService.updateEmployee(employee);
	}

}
