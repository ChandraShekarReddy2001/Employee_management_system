package com.emp.www.model;

public class HandelLogin {
private String username;
public HandelLogin() {
	super();
	// TODO Auto-generated constructor stub
}
public HandelLogin(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "HandelLogin [username=" + username + ", password=" + password + "]";
}
private String password;
}
