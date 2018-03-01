package com.sap.cf.odata.spring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sap.cf.odata.spring.model.Employee;
import com.sap.cf.odata.spring.repository.EmployeeRepository;

/**
 * 
 * @author fabiano.rosa
 *
 */

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;		

	@Override
	public List<Employee> findAllByFirstName(String firstName) {
		logger.info(">>> findAllByFirstName");		
		
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		return employees;
	}

	@Override
	public Employee findOneById(Integer id) {
		logger.info(">>> findOneById: " + id);		
		
		Employee employee = this.employeeRepository.findOne(id);	
		logger.info(">>> employee: " + employee);
		
		return employee;		
	}

	@Override
	@Transactional
	public Employee create(Employee employee) {
		logger.info(">>> create: " + employee);		
		
		Employee emp = this.employeeRepository.save(employee);
		//this.employeeRepository.flush();
		
		return emp;		
	}

	@Override
	public List<Employee> findAll() {		
		logger.info(">>> findAll");		
		
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		logger.info(">>> employees: " + employees);		
		
		return employees;
	}
	
}