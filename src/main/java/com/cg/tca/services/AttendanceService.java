package com.cg.tca.services;

import java.util.List;

import com.cg.tca.entities.Attendance;
import com.cg.tca.entities.Employee;
import com.cg.tca.exception.ResourceNotFoundException;

public interface AttendanceService {

	public List<Attendance> getAllAttendance();

	public boolean deleteAttendanceByEmpId(Integer attendanceId) throws ResourceNotFoundException;

	public int updateAttendanceById(Integer attendanceId, Attendance att) throws ResourceNotFoundException;

	public Attendance saveAttendanceDetails(Attendance att);
	
	public Attendance getAttendanceById(int attendanceId) throws ResourceNotFoundException;
	
	boolean deleteAttendanceById(Integer attendanceId) throws ResourceNotFoundException;

	public Employee getEmpById(int empId) throws ResourceNotFoundException;
	
	public Attendance addAttendence(Attendance att);
	

}
