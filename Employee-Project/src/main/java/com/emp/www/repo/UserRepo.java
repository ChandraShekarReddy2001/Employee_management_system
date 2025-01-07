package com.emp.www.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.www.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

}
