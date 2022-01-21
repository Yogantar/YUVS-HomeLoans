package com.example.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int acc_id;
	private String accountnumber;
	
	private double balance;
	private double interest=0.1;
	private int tenure=2;

	
	

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Transaction> TransactionList;
	
	public List<Transaction> getTransactionList() {
		return TransactionList;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		TransactionList = transactionList;
	}

	public int getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}


	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	

	

	public Account(int acc_id, String accountnumber, double balance, double interest, int tenure) {
		super();
		this.acc_id = acc_id;
		this.accountnumber = accountnumber;
		this.balance = balance;
		this.interest = interest;
		this.tenure = tenure;
//		TransactionList = transactionList;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
}
