package com.example.repositoy;

import com.example.model.Account;

public class NoSqlAccountRepository implements AccountRepository {
	
	public NoSqlAccountRepository() {
		System.out.println("NoSqlRepository instance created..");
	}

	public Account loadAccount(String number) {
		System.out.println("loading account "+number);
		return new Account(number, 1000.00);
	}

	public Account updateAccount(Account account) {
		// ..
		System.out.println("updating account "+account.getNumber());
		return account;
	}

}
