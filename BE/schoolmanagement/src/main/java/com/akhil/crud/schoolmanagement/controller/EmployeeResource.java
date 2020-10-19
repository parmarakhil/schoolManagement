package com.akhil.crud.schoolmanagement.controller;

import java.util.*;

import javax.validation.Valid;

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

import com.akhil.crud.schoolmanagement.error.DataNotFoundException;
import com.akhil.crud.schoolmanagement.model.Employee;
import com.akhil.crud.schoolmanagement.repository.EmployeeRepository;

/*
 * Employee controller for all CRUD operations
 */
@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class EmployeeResource {

	@Autowired
    private EmployeeRepository employeeRepository;

	/*
	 * get all employees
	 */
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /*
	 * get employee for a given id
	 * @Input id
	 */
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
        throws DataNotFoundException {
        Optional<Employee> option = employeeRepository.findById(employeeId);
        if(option.isEmpty())
          throw new DataNotFoundException("Employee not found for this id :: " + employeeId);
        return ResponseEntity.ok().body(option.get());
    }
    
    /*
	 * create a new employee
	 * @Input employee
	 */
    
    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
    
    /*
	 * update employee
	 * @Input employee
	 */

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
         @Valid @RequestBody Employee employeeDetails) throws DataNotFoundException {
    	Optional<Employee> option = employeeRepository.findById(employeeId);
        if(option.isEmpty())
          throw new DataNotFoundException("Employee not found for this id :: " + employeeId);
        Employee employee=option.get();

        employee.setDeptName(employeeDetails.getDeptName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
    /*
	 * delete an employee
	 * @Input id
	 *
	 */

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
         throws DataNotFoundException {
    	Optional<Employee> option = employeeRepository.findById(employeeId);
        if(option.isEmpty())
          throw new DataNotFoundException("Employee not found for this id :: " + employeeId);
        employeeRepository.delete(option.get());
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

