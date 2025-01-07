package com.emp.www.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.www.model.Employee;
import com.emp.www.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/e1/")
public class EmployeeController {
	@Autowired
	EmployeeService empservice;
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return empservice.getAllEmployees();
	}
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {

		return empservice.createEmployee(employee);
	}
	@GetMapping("employees/{id}")
	public Employee getEmployee(@PathVariable int id) {

		return empservice.getEmployee(id);
	}
	@PutMapping("employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		return empservice.updateEmployee(id, employee);
	}
	@DeleteMapping("employees/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable int id)
	{
		return empservice.deleteEmployee(id);
	}
	
	
}
