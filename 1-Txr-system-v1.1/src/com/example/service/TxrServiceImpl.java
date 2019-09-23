package com.example.service;

import com.example.model.Account;
import com.example.repositoy.SqlRepository;

public class TxrServiceImpl {
	
	public TxrServiceImpl() {
		System.out.println("TxrServiceImpl instance created");
	}

	public boolean transfer(double amount, String fromAccNumber, String toAccNumber) {

		System.out.println("txr intiated..");
		
		SqlRepository repository = new SqlRepository();

		Account fromAccount = repository.loadAccount(fromAccNumber);
		Account toAccount = repository.loadAccount(toAccNumber);

		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		repository.updateAccount(fromAccount);
		repository.updateAccount(toAccount);
		
		System.out.println("txr finished..");

		return true;

	}

}
