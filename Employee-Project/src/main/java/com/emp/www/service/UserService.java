package com.emp.www.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.www.model.HandelLogin;
import com.emp.www.model.User;
import com.emp.www.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo userrepo;
	
	public User saveUser(User user) {
		return userrepo.save(user);
	}
	public boolean loginUser(HandelLogin handelLogin) {
		Optional<User> user=userrepo.findById(handelLogin.getUsername());
		if(user ==null) {return false;}
		if(user !=null) {
			if(user.get().getPassword().equals(handelLogin.getPassword())){
				return true;
			}
			else {
				return false;
			
			}
		} else
			return false;
	}

}
