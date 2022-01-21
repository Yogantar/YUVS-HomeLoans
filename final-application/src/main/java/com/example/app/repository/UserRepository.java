package com.example.app.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findById(int id);
	User findByEmailAndPassword(String email, String password);
}
