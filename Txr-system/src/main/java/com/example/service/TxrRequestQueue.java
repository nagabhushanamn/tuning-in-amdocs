package com.example.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.web.TxrRequest;

@Service
public class TxrRequestQueue {

	private List<TxrRequest> requests = new ArrayList<TxrRequest>(); //

	private volatile int nextAvaialbleId = 0;
	private int lastProcessedId = 0;

	public synchronized void addTxrRequest(TxrRequest request) {
		request.setId(nextAvaialbleId);
		requests.add(request);
		nextAvaialbleId++;
	}

	public synchronized TxrRequest getNextTxrRequest() {
		// ---------------------------------------------------------
		// memory leak
		// ---------------------------------------------------------

		if (requests.size() > 0) {
			if (lastProcessedId < requests.size()) {
				TxrRequest request = requests.get(lastProcessedId);
				lastProcessedId++;
				return request;
			} else
				return null;
		} else {
			return null;
		}

		// ---------------------------------------------------------
		// no memory leak
		// ---------------------------------------------------------

//		if (requests.size() > 0) {
//			return requests.remove(0);
//		} else {
//			return null;
//		}

	}

	public void printSummary() {
		int size = requests.size();
		System.out.println("" + new Date() + " requests in queue : " + size + " of " + nextAvaialbleId);
	}

}
