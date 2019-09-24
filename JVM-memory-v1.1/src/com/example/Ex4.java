package com.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.util.Optional; //  JDK 1.8
import java.util.UUID;

/*
 * 
 *  memory leak
 * 
 */

class TxrRequest {

	private int id;
	private String fromAccNumber;
	private String toAccNumber;
	private double amount;

	public TxrRequest(String fromAccNumber, String toAccNumber, double amount) {
		super();
		this.fromAccNumber = fromAccNumber;
		this.toAccNumber = toAccNumber;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public String getFromAccNumber() {
		return fromAccNumber;
	}

	public String getToAccNumber() {
		return toAccNumber;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFromAccNumber(String fromAccNumber) {
		this.fromAccNumber = fromAccNumber;
	}

	public void setToAccNumber(String toAccNumber) {
		this.toAccNumber = toAccNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}

// Leaky Queue

class TxrRequestQueue {

	private List<TxrRequest> queue = new ArrayList<TxrRequest>(); //

	private int nextAvaialbleId = 0;
	private int lastProcessedId = -1;

	public void addTxrRequest(TxrRequest request) {
		synchronized (this) {
			request.setId(nextAvaialbleId);
			synchronized (queue) {
				queue.add(request);
			}
			nextAvaialbleId++;
		}
	}

	public TxrRequest getNextTxrRequest() {

		// memory leak
		
		synchronized (this) {
			if (lastProcessedId + 1 > nextAvaialbleId) {
				lastProcessedId++;
				return queue.get(lastProcessedId);
			} else
				return null;
		}

		// no memory leak
//		synchronized (this) {
//			if (queue.size() > 0) {
//				return queue.remove(0);
//			} else
//				return null;
//		}

	}

	public void printSummary() {
		int size = queue.size();
		System.out.println("" + new Date() + " requests in queue : " + size + " of " + nextAvaialbleId);
	}

}

class GenerateTxrRequestTask implements Runnable {

	private TxrRequestQueue txrRequestQueue;

	public GenerateTxrRequestTask(TxrRequestQueue txrRequestQueue) {
		super();
		this.txrRequestQueue = txrRequestQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				// This is just to slow things down so we can see what's going on!
				Thread.sleep(2);
			} catch (InterruptedException e) {
			}
			String fromAccNumber = UUID.randomUUID().toString();
			String toAccNumber = UUID.randomUUID().toString();

			TxrRequest request = new TxrRequest(fromAccNumber, toAccNumber, 100.00);
			txrRequestQueue.addTxrRequest(request);
		}
	}

}

class ProcessTxrRequestTask implements Runnable {

	private TxrRequestQueue txrRequestQueue;

	public ProcessTxrRequestTask(TxrRequestQueue txrRequestQueue) {
		super();
		this.txrRequestQueue = txrRequestQueue;
	}

	@Override
	public void run() {
		while (true) {
			TxrRequest request = txrRequestQueue.getNextTxrRequest();
			if (request == null) {
				// no customers in queue so pause for half a second
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				// Processing takes place here
			}
		}

	}

}

public class Ex4 {

	public static void main(String[] args) {

		TxrRequestQueue txrRequestQueue = new TxrRequestQueue();

		GenerateTxrRequestTask generateTxrRequestTask = new GenerateTxrRequestTask(txrRequestQueue);
		ProcessTxrRequestTask processTxrRequestTask = new ProcessTxrRequestTask(txrRequestQueue);

		for (int user = 0; user < 10; user++) {
			Thread t = new Thread(generateTxrRequestTask);
			t.start();
		}

		Thread t = new Thread(processTxrRequestTask);
		t.start();

		// main thread is now acting as the monitoring thread
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			txrRequestQueue.printSummary();
			System.out.println("Available memory: " + Runtime.getRuntime().freeMemory() / 1024 + "k");

		}

	}

}
