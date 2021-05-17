package com.cg.tca.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.tca.entities.Attendance;
import com.cg.tca.entities.Employee;



@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Integer>{
	
	//@Query("select att from Attendance att where att.employee=:emp")
    //List<Attendance> findByEmp(Employee emp);
	
	@Query("select att from Attendance att where att.employee=(select emp from Employee emp where emp.employeeId=:empId)")
	public Employee findByEmpId(Integer employeeId);
	
	@Transactional
	@Modifying
	@Query("delete from Attendance att where att.attendanceId=:id")
	void deleteId(int id);

	public Attendance create(Attendance att);
}
