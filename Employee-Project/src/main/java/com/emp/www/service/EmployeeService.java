package com.emp.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.emp.www.Exception.ResourceNotFoundException;
import com.emp.www.model.Employee;
import com.emp.www.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	private static final Object updateEmployee = null;
	@Autowired
	EmployeeRepo emprepo;
	
	public List<Employee> getAllEmployees(){
		return emprepo.findAll();
	} 
	public Employee createEmployee(@RequestBody Employee employee) {

		return emprepo.save(employee);
	}
	
	public Employee getEmployee(int id) {

		return emprepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id Not Found"));
	}
	
	public ResponseEntity<Employee> updateEmployee(int id,Employee employee) {
	
		Employee emp=emprepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Does not exist"));
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmail(employee.getEmail());
		emp.setAddress(employee.getAddress());
		emp.setPhoneNumber(employee.getPhoneNumber());
		Employee updatemp=emprepo.save(emp);
		return ResponseEntity.ok(updatemp);
	}
	public ResponseEntity<HttpStatus> deleteEmployee(int id)
	{
		Employee employee=emprepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee Does not Exit"));
		emprepo.delete(employee);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
