package com.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.project.Model.UserSession;

public interface UserSessionDAO extends JpaRepository<UserSession, Integer>, JpaSpecificationExecutor<UserSession> {

	UserSession findByToken(String token);

	@Query("select us from UserSession us where us.userId = :userId and us.token = :token")
	UserSession findUserSessionByUserIdAndToken(int userId, String token);

}
