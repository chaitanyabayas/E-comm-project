package ec.com.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.com.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByMobileNumber(String mobileNumber);

	@Query(value = "SELECT u FROM User u WHERE u.firstName LIKE %:name%")
	List<User> findByUserName(@Param("name") String name);

	void deleteById(int id);
}
