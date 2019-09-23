package com.example.repositoy;

import com.example.model.Account;

public class SqlAccountRepository implements AccountRepository {
	
	public SqlAccountRepository() {
		System.out.println("SqlRepository instance created..");
	}

	@Override
	public Account loadAccount(String number) {
		// .. jdbc | jpa
		System.out.println("loading account "+number);
		return new Account(number, 1000.00);
	}

	@Override
	public Account updateAccount(Account account) {
		// ..
		System.out.println("updating account "+account.getNumber());
		return account;
	}

}
