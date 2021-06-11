package com.cg.tca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tca.entities.Employee;
import com.cg.tca.entities.Supervisor;
import com.cg.tca.exception.ResourceNotFoundException;
import com.cg.tca.repository.EmployeeRepository;
import com.cg.tca.services.EmployeeService;
import com.cg.tca.services.SupervisorService;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private SupervisorService supService;
	
	@Autowired
	private EmployeeRepository empRepository;

	@PostMapping("/")
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
		employeeService.createEmployee(employee);
		return new ResponseEntity<String>("Employee Created", HttpStatus.CREATED);
	}

	@GetMapping("/")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable(value = "id") int empId) throws ResourceNotFoundException {
		Employee employee = employeeService.getEmpById(empId);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Integer employeeId,
			@RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeService.updateEmployee(employeeId, employeeDetails);
		return ResponseEntity.ok(employee);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable(value = "id") Integer employeeId)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(employeeService.deleteEmployeeById(employeeId));
	}

	@PostMapping("/login")
	public Employee loginVerify(@RequestBody Employee employee) {
		Employee u=empRepository.findByEmployeeEmailAndPassword(employee.getEmployeeEmail(), employee.getPassword());
		return u;
	}
	
	

}
