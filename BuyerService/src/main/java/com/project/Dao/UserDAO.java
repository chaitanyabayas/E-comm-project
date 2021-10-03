package com.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Model.User;

public interface UserDAO extends JpaRepository<User, Integer> {

}
