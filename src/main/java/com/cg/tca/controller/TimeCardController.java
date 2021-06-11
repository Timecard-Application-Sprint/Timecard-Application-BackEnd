

package com.cg.tca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.cg.tca.entities.TimeCard;
import com.cg.tca.exception.ResourceNotFoundException;
import com.cg.tca.services.EmployeeService;
import com.cg.tca.services.TimeCardService;

@RestController
@RequestMapping("/api/timecard")
@CrossOrigin
public class TimeCardController {

	@Autowired
	private TimeCardService timeCardService;
	@Autowired
	private EmployeeService empSer;

	@GetMapping("/all")
	public List<TimeCard> getAllTimeCard() {
		return timeCardService.getAllTimeCard();
	}

	@PostMapping("/{emp_id}")
	public TimeCard createTimeCard(@PathVariable(value = "emp_id") Integer empId, @RequestBody TimeCard tc)
			throws ResourceNotFoundException {
		Employee employee = empSer.getEmpById(empId);
		if (employee != null)
			tc.setEmployee(employee);
		tc.setStatus("Pending");
		return timeCardService.saveTimeCard(tc);
	}

	@GetMapping("/{id}")
	public TimeCard getTimeCardById(@PathVariable(value = "id") int timeCardId) throws ResourceNotFoundException {
		return timeCardService.getTimeCardById(timeCardId);
	}

	
	@DeleteMapping("/delete/{id}")
	public Boolean deleteTimeCard(@PathVariable(value = "id") Integer timeCardId) throws ResourceNotFoundException {
		Boolean tc1 = timeCardService.deleteTimeCardById(timeCardId);

		return tc1;
	}
	@PutMapping("/update/{tc_id}")
	public Integer editTimeCard(@PathVariable("tc_id") Integer id, @RequestBody TimeCard tcard)
			throws ResourceNotFoundException {
		return timeCardService.updateTimeCardById(id, tcard);
	}
}
