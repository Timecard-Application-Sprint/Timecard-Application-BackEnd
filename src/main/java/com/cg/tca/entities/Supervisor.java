package com.cg.tca.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;



@Entity
@Data
@Table(name="SUPERVISOR")
public class Supervisor {
	@Id
	@Column(name="SUP_ID")
	private int supervisorId;
	@OneToMany(mappedBy = "supervisor",cascade = CascadeType.ALL)
	@JsonManagedReference
	@Column(name="EMP_ID")
	private Set<Employee> emps;
	@Column(name="SUP_NAME")
	private String supervisorName;
	@Column(name="SUP_PHNO")
	private String supervisorNumber;
	@Column(name="SUP_EMAIL")
	private String supervisorEmail;
	@Column(name="PASSWORD")
	private String password;
	@Column(name="USER_ID")
	private String userId;
}
	
