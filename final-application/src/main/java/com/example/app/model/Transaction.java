package com.example.app.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tran_id;
	private Date tran_date;
	private String from_account;
	private String to_account="bankCC";
	private double tran_amount;

	@ManyToOne
	@JoinColumn(name = "account_acc_id")
	private Account account;

	public Transaction(int tran_id, Date tran_date, String from_account, String to_account, double tran_amount,
			Account account) {
		super();
		this.tran_id = tran_id;
		this.tran_date = tran_date;
		this.from_account = from_account;
		this.to_account = to_account;
		this.tran_amount = tran_amount;
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTran_id() {
		return tran_id;
	}

	public void setTran_id(int tran_id) {
		this.tran_id = tran_id;
	}

	public Date getTran_date() {
		return tran_date;
	}

	public void setTran_date(Date l) {
		this.tran_date = l;
	}

	public String getFrom_account() {
		return from_account;
	}

	public void setFrom_account(String from_account) {
		this.from_account = from_account;
	}

	public String getTo_account() {
		return to_account;
	}

	public void setTo_account(String to_account) {
		this.to_account = to_account;
	}

	public double getTran_amount() {
		return tran_amount;
	}

	public void setTran_amount(double tran_amount) {
		this.tran_amount = tran_amount;
	}
}
