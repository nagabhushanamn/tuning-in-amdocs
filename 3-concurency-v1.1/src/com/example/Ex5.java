package com.example;

import java.util.concurrent.TimeUnit;

/*
 * 
 *  thread states
 *  ---------------
 *  
 *  NEW
 *  RUNNABLE
 *  TIMED_WAITING
 *  BLOCKED
 *  WAITING
 *  TERMINATED
 *  
 * 
 */

class Room {
	public synchronized void takeRest() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " going to sleep in room");
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " leaving room");
	}
}

public class Ex5 {

	public static void main(String[] args) throws InterruptedException {

		Room room = new Room();

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				room.takeRest();
			}
		};

		Thread thread1 = new Thread(runnable, "BOY");
		thread1.start(); 

		Thread thread2 = new Thread(runnable, "GIRL");
		thread2.start();

		TimeUnit.SECONDS.sleep(2);

		System.out.println(thread1.getState());
		System.out.println(thread2.getState());

	}

}
