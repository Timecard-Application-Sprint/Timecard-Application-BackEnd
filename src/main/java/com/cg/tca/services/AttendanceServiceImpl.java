package com.cg.tca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tca.entities.Attendance;
import com.cg.tca.entities.Employee;
import com.cg.tca.exception.ResourceNotFoundException;
import com.cg.tca.repository.AttendanceRepository;
import com.cg.tca.repository.EmployeeRepository;

@Service
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired
	private AttendanceRepository attdetails;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Attendance> getAllAttendance() {
		return attdetails.findAll();
	}
	
	@Override
	public Employee getEmpById(int empId) throws ResourceNotFoundException {
	 Employee emp=employeeRepository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + empId));
	 return emp;
	 }

	@Override
	public boolean deleteAttendanceByEmpId(Integer attendanceId) throws ResourceNotFoundException {
		boolean del;
		Attendance att = attdetails.findById(attendanceId).orElseThrow(
				() -> new ResourceNotFoundException("Attendance not found for this id :: " + attendanceId));
		del = att != null;
		attdetails.deleteId(attendanceId);
		return del;
	}

	@Override
	public boolean deleteAttendanceById(Integer attendanceId) throws ResourceNotFoundException {
		Attendance attendance = attdetails.findById(attendanceId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + attendanceId));
		attdetails.delete(attendance);
		return true;
	}

	@Override
	public int updateAttendanceById(Integer attendanceId, Attendance atts) throws ResourceNotFoundException {
		Attendance att = attdetails.findById(attendanceId).orElseThrow(
				() -> new ResourceNotFoundException("Attendance not found for this id :: " + attendanceId));
		att.setInTime(atts.getInTime());
		att.setOffTime(atts.getOffTime());
		att.setFromDate(atts.getFromDate());
		att.setToDate(atts.getToDate());
		att.setStatus(atts.getStatus());
		attdetails.save(att);

		return att.getAttendanceId();
	}

	@Override
	public Attendance saveAttendanceDetails(Attendance att) {
		if (att.getToDate() == null) {
			att.setToDate(att.getFromDate());
		}
		return attdetails.save(att);
	}

	@Override
	public Attendance getAttendanceById(int attendanceId) throws ResourceNotFoundException {
		Attendance att = attdetails.findById(attendanceId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + attendanceId));

		return att;
	}	

	@Override
	public Attendance addAttendence(Attendance att) {
		return attdetails.create(att);
	}

	@Autowired
	public Attendance create(Attendance att) {
		return attdetails.save(att);
		
	}

}

