package com.example.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.repository.UserRepository;

@Service
@Transactional
public class UserService {


	@Autowired
	public UserRepository userRepository;
	
	public void delete(int id) {
		userRepository.deleteById(id); // defined in JPA repo
		}
}
