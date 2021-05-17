package com.cg.tca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tca.entities.Attendance;
import com.cg.tca.entities.Employee;
import com.cg.tca.exception.ResourceNotFoundException;
import com.cg.tca.services.AttendanceServiceImpl;
import com.cg.tca.services.EmployeeService;

@RestController
@RequestMapping("/api/v1/attendance")

public class AttendanceController {

	@Autowired
	private AttendanceServiceImpl attendanceService;
	@Autowired
	private EmployeeService empSer;

	@GetMapping("/all")
	public List<Attendance> getAllAttendance() {
		return attendanceService.getAllAttendance();
	}
	
	/**@PostMapping("/apply/{emp_id}")
		public Leave addLeave(@RequestBody Leave leave ,@PathVariable(value = "emp_id") Integer empId ) throws ResourceNotFoundException {
			Employee employee=empSer.getEmpById(empId);
			if(employee!=null)
				leave.setEmployee(employee); 
				leave.setStatus("Pending");
			return leaveservice.addLeave(leave);
		}**/

	@PostMapping("/addattendance/{emp_id}")
	public String addAttendance(@PathVariable(value = "emp_id") Integer empId, @RequestBody Attendance att) throws ResourceNotFoundException {
		Employee employee = empSer.getEmpById(empId);
		if (employee!=null)
			att.setEmployee(employee);
			att.setStatus("Pending");
			attendanceService.create(att);
			return "Leave Applied";
	}

	@GetMapping("/{id}")
	public Attendance getByAttendanceId(@PathVariable(value = "id") int attendanceId) throws ResourceNotFoundException {
		return attendanceService.getAttendanceById(attendanceId);
	}

	@PutMapping("/update/{id}")
	public int updateAttendanceById(@PathVariable(value = "id") Integer attendanceId, @RequestBody Attendance attendanceDetails) throws ResourceNotFoundException {
		return attendanceService.updateAttendanceById(attendanceId, attendanceDetails);
	}

	@DeleteMapping("/delete/{id}")
	public Boolean deleteAttendance(@PathVariable(value = "id") Integer attendanceId) throws ResourceNotFoundException {
		Boolean att1 = attendanceService.deleteAttendanceById(attendanceId);

		return att1;
	}

	@PostMapping("/create")
	public String createAttendance(@RequestBody Attendance attendance) {
		attendance.setStatus("Pending");
		attendanceService.create(attendance);
		return "Attendance Created";
	}

}
