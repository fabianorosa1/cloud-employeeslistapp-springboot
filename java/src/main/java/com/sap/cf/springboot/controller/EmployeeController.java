package com.sap.cf.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sap.cf.springboot.model.Employee;
import com.sap.cf.springboot.service.IEmployeeService;

/**
 * 
 * @author fabiano.rosa
 *
 */

@RestController
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private IEmployeeService employeeService;

	@GetMapping("/home")
	@ResponseBody
	public String getHome() {
		logger.info(">>> GET Home - SERVICE");		
		
		return "SpringBoot Employee List - Home Works !!!!";
	}
	
	@GetMapping("/create")
	@ResponseBody
	public Employee createEmployee() {
		logger.info(">>> createEmployee");
		
		Employee employee = new Employee();
		employee.setFirstName("testeFirst-" + this.hashCode());
		employee.setLastName("testeLast-" + this.hashCode());
						
		return employeeService.create(employee);
	}
		
	@GetMapping("/employee/{id}")
	@ResponseBody
	public Employee getEmployeeById(@PathVariable(value = "id") final Integer id) {
		logger.info("GET Employee BY ID: " + id);
		
		return employeeService.findOneById(id);
	}
	
	@GetMapping("/employees")
	@ResponseBody
	public List<Employee> getAllEmployees() {
		logger.info("GET ALL Employee");
		List<Employee> listEmployee = employeeService.findAll();
		
		return listEmployee;
	}	
}
