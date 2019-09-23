package com.example;

import com.example.repositoy.AccountRepository;
import com.example.repositoy.NoSqlAccountRepository;
import com.example.service.TxrService;
import com.example.service.TxrServiceImpl;

public class App {

	public static void main(String[] args) {

		// init / booting
		AccountRepository accountRepository = new NoSqlAccountRepository();
		TxrService service = new TxrServiceImpl(accountRepository);
		System.out.println();

		// use
		service.transfer(100.00, "1", "2");
		System.out.println();
		service.transfer(100.00, "2", "1");

		// destroy
		service = null;

	}

}
