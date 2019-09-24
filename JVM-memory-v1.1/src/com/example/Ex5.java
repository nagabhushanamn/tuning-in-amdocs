package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Account;

public class Ex5 {
	
	public static void main(String[] args) {
		
		List<Account> accounts=new ArrayList<Account>();
		
		while(true) {
			Account account=new Account("1", 100.00);
			accounts.add(account);
			if(accounts.size()>1000) {
				for (int i = 0; i < 100; i++) {
					accounts.remove(0);
				}
			}
			
		}
			
	}

}
