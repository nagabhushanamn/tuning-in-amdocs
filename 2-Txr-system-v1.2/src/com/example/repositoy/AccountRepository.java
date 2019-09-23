package com.example.repositoy;

import com.example.model.Account;

public interface AccountRepository {

	Account loadAccount(String number);

	Account updateAccount(Account account);

}