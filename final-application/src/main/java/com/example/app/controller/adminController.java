package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.Account;
import com.example.app.model.User;
import com.example.app.repository.AccountRepository;
import com.example.app.repository.UserRepository;
import com.example.app.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class adminController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private UserService service;
	
	@GetMapping("/getUserAccountDetails")
    public List<User> getAccountBalance() {
        return userRepository.findAll(); 
    }
	
	@DeleteMapping("/delete/{id}")
	public List<User> deleteUser(@PathVariable("id") int id) {
		User u=userRepository.findById(id);
		userRepository.delete(u);// delete record based on ID
		int aid=id-1;
		Account a=accountRepository.findById(aid);
		accountRepository.delete(a);
	return userRepository.findAll();
	}
}
