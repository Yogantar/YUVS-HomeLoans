package com.example.app.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.Account;
import com.example.app.model.Transaction;
import com.example.app.model.User;
import com.example.app.repository.AccountRepository;
import com.example.app.repository.TransactionRepository;
import com.example.app.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	//register user api
	@PostMapping("/register")
    public String register(@RequestBody User user) {
        Account account = new Account();
        account.setAccountnumber("");
        account.setBalance(0.0);
        account.setInterest(0.0);
        account.setTenure(0);
        user.setAccount(account);
        accountRepository.save(account);
        userRepository.save(user);
        return "Your registration is completed";
    }
	
	//api for getting user details
	@GetMapping("/getUsers/{id}")
    public User findUsers(@PathVariable int id) {
        return userRepository.findById(id);
    }
	
	@GetMapping("/userdetail/{email}/{password}")
	public User getUserDetails(@PathVariable String email, @PathVariable String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
	
//	ACCOUNT CONTROLS
	
	//api for depositing money
	@PutMapping("/deposite/{id}")
    public String deposite(@PathVariable int id, @RequestBody Account account) {
		Account tempAccount = accountRepository.findById(id);
		double currentBalance = tempAccount.getBalance();
		tempAccount.setBalance(currentBalance - account.getBalance());
        accountRepository.save(tempAccount);
        return "You have successfully deposited amount: " + tempAccount.getBalance() ;
    }
	
	//adding account details
	@PutMapping("/addAccount/{id}")
    public String addAccount(@PathVariable int id, @RequestBody Account account) {
		Account tempAccount = accountRepository.findById(id);
		tempAccount.setAccountnumber(account.getAccountnumber());
		tempAccount.setInterest(account.getInterest());
		tempAccount.setTenure(account.getTenure());
		tempAccount.setBalance(account.getBalance()*(1+(account.getInterest()*account.getTenure())));
        accountRepository.save(tempAccount);
        return "Hi, you have successfully added account: " + account.getAccountnumber() ;
    }
	
	// fetching account details
	@GetMapping("/getAccountDetails")
    public List<Account> getAccountBalance() {
        return accountRepository.findAll();
    }
	
	// TRANSACTION CONTROLS
	
	@PostMapping("/sendTransaction/{id}")
	public String sendMoney(@PathVariable int id, @RequestBody Transaction transaction) {
		Account fa = accountRepository.findById(id);
		String acc = fa.getAccountnumber();
	
		transaction.setTo_account(transaction.getTo_account());
		transaction.setFrom_account(acc);
		transaction.getTran_amount();
		fa.setBalance(fa.getBalance()-transaction.getTran_amount());
		accountRepository.save(fa);
		transaction.setAccount(fa);
		long milli = System.currentTimeMillis();
		java.sql.Date date =  new Date(milli);
		transaction.setTran_date(date);
		transactionRepository.save(transaction);
		return "Transaction of : " + transaction.getTran_amount() + " is successfully performed";   
		}
//	
//	@GetMapping("/getSentDetails/{id}")
//	public Optional<Transaction> getTransaction(@PathVariable int id)
//	{
//		return transactionRepository.findById(id);
//	}
}
