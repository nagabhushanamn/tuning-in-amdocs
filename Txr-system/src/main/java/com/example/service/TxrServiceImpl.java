package com.example.service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Account;
import com.example.repository.AccountRepository;

@Service("txrService")
public class TxrServiceImpl implements TxrService {

	private AccountRepository accountRepository;

	public TxrServiceImpl(@Qualifier("jpa") AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}


	@Transactional
	public  boolean txr(Double amount, String fromAccNum, String toAccNum) {

		
		Account fromAccount = accountRepository.findById(fromAccNum).get();
		Account toAccount = accountRepository.findById(toAccNum).get();

		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);
		

		// update accounts
		accountRepository.save(fromAccount);
		accountRepository.save(toAccount);

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return true;
	}

}
