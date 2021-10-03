package com.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.Model.UserAddress;

public interface UserAddressDAO extends JpaRepository<UserAddress, Integer> {

	@Query("select address from UserAddress address where address.userId = :id")
	UserAddress findUserAddressByUserId(Integer id);

}
