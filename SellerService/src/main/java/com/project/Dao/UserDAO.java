package com.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.project.Model.User;

public interface UserDAO extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

	User findByEmailIgnoreCase(String email);

	@Query("select user from User user where user.id = :id and user.active = 1")
	User findUserById(Integer id);

	@Query("select user from User user where user.email = :email and user.active = 1")
	User findActiveByUsername(String email);

	@Query("select user from User user where user.email = :email and user.active = 1")
	User findActiveUserByEmail(String email);

	@Query("select user from User user where user.mobileNo = :mobileNo and user.active = 1")
	User findActiveUserByMobileNo(String mobileNo);

}
