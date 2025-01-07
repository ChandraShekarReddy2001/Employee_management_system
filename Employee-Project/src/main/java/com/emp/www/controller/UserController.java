package com.emp.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.www.model.HandelLogin;
import com.emp.www.model.User;
import com.emp.www.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("api/employee/")
public class UserController {
	@Autowired
UserService userservice;
	@PostMapping("/register")
	public User postMethodName(@RequestBody User user) {
		return userservice.saveUser(user) ;
	}
	
	@PostMapping("/login")
	public boolean loginUser(@RequestBody HandelLogin handelLogin) {
		
		System.out.println(handelLogin);
		return userservice.loginUser(handelLogin);
	}
	
}
