package com.example.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web.TxrRequest;

@Service
public class TxrSystem {

	@Autowired
	private TxrRequestQueue txrRequestQueue;

	@Autowired
	private TxrService txrService;

	private ExecutorService executorService = Executors.newFixedThreadPool(10);

	class ProcessTxrRequestTask implements Runnable {

		@Override
		public void run() {
			while (true) {
				TxrRequest request = txrRequestQueue.getNextTxrRequest();
				if (request == null) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {

//					txrService.txr(request.getAmount(), request.getFromAccNum(), request.getToAccNum());
				
					executorService.submit(new Runnable() {
						@Override
						public void run() {
							txrService.txr(request.getAmount(), request.getFromAccNum(), request.getToAccNum());
						}
					});

				}
			}

		}

	}

	@PostConstruct
	public void init() {
		Thread thread = new Thread(new ProcessTxrRequestTask(), "ProcessTxrRequestManager");
		thread.start();
	}
}
