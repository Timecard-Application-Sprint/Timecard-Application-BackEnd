package com.cg.tca.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.tca.entities.Employee;
import com.cg.tca.entities.TimeCard;

@Repository
public interface TimeCardRepository extends JpaRepository<TimeCard, Integer> {

}

/**package com.cg.tca.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.tca.entities.TimeCard;

@Repository
public interface TimeCardRepository extends JpaRepository<TimeCard, Integer> {

	//@Query("select att from Attendance att where att.employee=:emp")
   // List<TimeCard> findByEmp(Employee emp);
	
	@Query("select tc from TimeCard tc where tc.employee=(select emp from Employee emp where emp.employeeId=:empId)")
	List<TimeCard> findByEmpId(int empId);
	
	@Transactional
	@Modifying
	@Query("delete fromTimeCard tc where tc.timeCardId=:id")
	void deleteId(int id);
}**/