package com.emp.www.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
@Column
private String  name;
@Column
private String userName;
@Id
private String email;

@Column
private String password;
public User() {
	
}
public User(String name, String userName, String email, String password) {
	super();
	this.name = name;
	this.userName = userName;
	this.email = email;
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
