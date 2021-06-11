package com.cg.tca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.tca.entities.Employee;
import com.cg.tca.entities.Supervisor;

@Repository
public interface SupervisorRepository extends JpaRepository<Supervisor, Integer> {
	public Supervisor findBySupervisorEmailAndPassword(String supervisorEmail,String password);

}
