package com.example;

/*
 * 
 *  race condition
 * 
 */

class Counter {
	private long count = 0;
	
	private Object monitor=new Object();

	public  void increment() {
		synchronized (monitor) {
			count += 1; // read -> increment -> write	
		}
	}

	public long get() {
		return count;
	}
}

public class Ex2 {

	public static void main(String[] args) throws InterruptedException {


		Counter counter = new Counter();

		Runnable task = () -> {
			for (int i = 0; i < 1000; i++) {
				counter.increment();
			}
		};

		Thread[] threads = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(task);
			threads[i].start();
		}

		for (int i = 0; i < 10; i++) {
			threads[i].join();
		}

		System.out.println(counter.get()); // 1000 * 1000 = 1000000

	}

}
