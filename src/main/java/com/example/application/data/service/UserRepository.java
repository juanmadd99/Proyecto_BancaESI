package com.example.application.data.service;

import com.example.application.data.entity.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.application.data.Role;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}