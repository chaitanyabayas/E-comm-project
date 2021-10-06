package com.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.Model.User;

public interface UserDAO extends JpaRepository<User, Integer> {

	@Query("select user from User user where user.id = :id")
	User findUserById(Integer id);

	@Query("select user from User user where user.email = :email")
	User findActiveByUsername(String email);

	@Query("select user from User user where user.email = :email")
	User findActiveUserByEmail(String email);

	@Query("select user from User user where user.mobileNo = :mobileNo")
	User findActiveUserByMobileNo(String mobileNo);

}
