package com.cwcdev.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cwcdev.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
	
	@Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.email =:email")
	User validaEmail(String email);
}
