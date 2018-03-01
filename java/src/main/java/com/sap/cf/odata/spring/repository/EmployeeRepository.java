package com.sap.cf.odata.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sap.cf.odata.spring.model.Employee;

/**
 * 
 * @author fabiano.rosa
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	public List<Employee> findAllByFirstName(String firstName);
	
	public Employee findOneById(String id);
	
}
