package com.example;

import java.util.Scanner;

// 

/*
 * 
 * why we need thread(s)
 * 
 * task(s)
 * -----------
 *  
 *  - computation
 *  - io
 * 
 * 
 */

public class Ex1 {

	public static void main(String[] args) {

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				io();
			}
		}, "IO");

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				computation();
			}
		}, "COMPUTATION");

		thread1.start(); // stack
		thread2.start(); // stack
		

	}

	private static void computation() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " initiated computation");
		boolean b = true;
		while (b) {
		}
		System.out.println(threadName + " finished computation");
	}

	private static void io() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " initiated io");
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter ur name");
		String name = scanner.nextLine();
		System.out.println("hello " + name);
		scanner.close();
		System.out.println(threadName + " finished io");
	}

}
