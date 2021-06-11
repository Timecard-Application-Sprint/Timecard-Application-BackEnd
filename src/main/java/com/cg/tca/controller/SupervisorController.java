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
import com.cg.tca.repository.SupervisorRepository;
import com.cg.tca.services.SupervisorService;

@RestController
@RequestMapping("/api/supervisor")
@CrossOrigin
public class SupervisorController {

	@Autowired
	private SupervisorService supervisorService;
	
	@Autowired
	private SupervisorRepository supRepository;


	@PostMapping("/")
	public ResponseEntity<Supervisor> createCompanySupervisor(@RequestBody Supervisor supervisor) {
		Supervisor sup = supervisorService.createSupervisor(supervisor);
		return new ResponseEntity<Supervisor>(sup, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteManager(@PathVariable(value = "id") Integer supervisorId)
			throws ResourceNotFoundException {

		boolean supervisor = supervisorService.deleteSupervisor(supervisorId);
		return ResponseEntity.ok(supervisor);
	}

	@GetMapping("/all")
	public List<Supervisor> getAllSupervisor() {
		return supervisorService.getAllSupervisor();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Supervisor> findById(@PathVariable(value = "id") int supervisorId)
			throws ResourceNotFoundException {
		Supervisor sup = supervisorService.getSupervisorById(supervisorId);
		return new ResponseEntity<Supervisor>(sup, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Supervisor> updateSupervisor(@PathVariable(value = "id") Integer supervisorId,
			@RequestBody Supervisor supervisorDetails) throws ResourceNotFoundException {
		Supervisor supervisor = supervisorService.updateSupervisor(supervisorId, supervisorDetails);
		return ResponseEntity.ok(supervisor);
	}
	
	@PostMapping("/login")
	public Supervisor loginVerify(@RequestBody Supervisor supervisor) {
		Supervisor sup=supRepository.findBySupervisorEmailAndPassword(supervisor.getSupervisorEmail(), supervisor.getPassword());
		return sup;
	}
}
	
	