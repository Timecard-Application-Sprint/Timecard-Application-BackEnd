package com.cg.tca.services;

import java.util.List;

import com.cg.tca.entities.Employee;
import com.cg.tca.exception.ResourceNotFoundException;

public interface EmployeeService {
	//Employee createEmployee(Employee employee) throws ResourceNotFoundException;

	Employee updateEmployee(Integer employeeId, Employee employeeDetails) throws ResourceNotFoundException;

	boolean deleteEmployeeById(Integer employeeId) throws ResourceNotFoundException;

	Employee getEmpById(int empId) throws ResourceNotFoundException;

	Employee create(Employee employee);

	List<Employee> getAllEmployee();


}
