package com.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.Model.User;

public interface UserDAO extends JpaRepository<User, Integer> {

	@Query("select user from User user where user.id = :id")
	User findUserById(Integer id);

}
