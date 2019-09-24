package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Account;

public class Ex3 {

	public static void main(String[] args) throws InterruptedException {

		Runtime runtime = Runtime.getRuntime(); // JRE -> JVM

		long availableBytes = runtime.freeMemory();
		System.out.println("Available memory at start: " + availableBytes / 1024 + "k");

		// let's create lots of objects
		List<Account> accounts = new ArrayList<Account>();

		for (int i = 0; i < 1000; i++) {
			Account account=new Account(String.valueOf(i), 1000.00);
//			accounts.add(new Account(String.valueOf(i), 1000.00));
		}

		availableBytes = runtime.freeMemory();
		System.out.println("Available memory when accounts created: " + availableBytes / 1024 + "k");

		accounts = new ArrayList<Account>();

		availableBytes = runtime.freeMemory();
		System.out.println("Available memory when accounts no longer referenced: " + availableBytes / 1024 + "k");

		Thread.sleep(1000);

		availableBytes = runtime.freeMemory();
		System.out.println("Available memory 1 second later: " + availableBytes / 1024 + "k");

		System.gc();

		availableBytes = runtime.freeMemory();
		System.out.println("Available memory after gc() command: " + availableBytes / 1024 + "k");

	}

}
