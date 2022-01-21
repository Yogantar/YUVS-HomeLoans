package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	Account findById(int id);
	Account findByAccountnumber(String account_number);
}
