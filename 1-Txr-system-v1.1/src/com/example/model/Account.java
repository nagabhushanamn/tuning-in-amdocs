package com.example.model;

public class Account {

	private String number;
	private double balance;

	public Account(String numbe, double balance) {
		super();
		this.number = numbe;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [numbe=" + number + ", balance=" + balance + "]";
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
