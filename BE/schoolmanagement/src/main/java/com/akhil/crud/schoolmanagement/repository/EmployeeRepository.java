package com.akhil.crud.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akhil.crud.schoolmanagement.model.Employee;
/*
 * repositroy for employee
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
