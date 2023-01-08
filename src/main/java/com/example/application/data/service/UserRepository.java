package com.example.application.data.service;

import com.example.application.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select u from user where u.lastName = :lastName")
	User findBylastName(@Param("lastName") String lastName);
	
	@Query("select max(u.id) from user u")
	int findLastId();
}
