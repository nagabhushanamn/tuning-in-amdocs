package com.example.service;

import com.example.model.Account;
import com.example.repositoy.AccountRepository;

public class TxrServiceImpl implements TxrService {

	private AccountRepository accountRepository;

	public TxrServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		System.out.println("TxrServiceImpl instance created");
	}

	@Override
	public boolean transfer(double amount, String fromAccNumber, String toAccNumber) {

		System.out.println("txr intiated..");

		Account fromAccount = accountRepository.loadAccount(fromAccNumber);
		Account toAccount = accountRepository.loadAccount(toAccNumber);

		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		accountRepository.updateAccount(fromAccount);
		accountRepository.updateAccount(toAccount);

		System.out.println("txr finished..");

		return true;

	}

}
