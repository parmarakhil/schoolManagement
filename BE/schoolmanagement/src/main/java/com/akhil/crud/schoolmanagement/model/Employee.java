package com.akhil.crud.schoolmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Employee POJO class
 */

@Entity
@Table(name ="employee")
public class Employee {
	
	/*
	 * employee id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/*
	 * first name of employee
	 */
	@Column(name="first_name")
	private String firstName;

	/*
	 * last name of employee
	 */
	@Column(name="last_name")
	private String lastName;
	
	/*
	 * employee's department 
	 */
	@Column(name="dept_name")
	private String deptName;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String firstName, String lastName, String deptName){
		this.firstName=firstName;
		this.lastName=lastName;
		this.deptName=deptName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
	
}
