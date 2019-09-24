package com.example.model;

public class Account {

	private String number;
	private double balance;

	public Account(String number, double balance) {
		super();
		this.number = number;
		this.balance = balance;
	}

	public Account() {
	}

	@Override
	public String toString() {
		return "Account [number=" + number + ", balance=" + balance + "]";
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

//	@Override
//	protected void finalize() throws Throwable {
//		System.out.println("this object is beaing g.c.'d " + this.number);
//		while (true) {
//		}
//	}

}
