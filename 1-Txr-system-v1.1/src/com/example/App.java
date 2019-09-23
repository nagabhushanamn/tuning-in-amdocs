package com.example;

import com.example.service.TxrServiceImpl;

public class App {

	public static void main(String[] args) {

		// init / booting
		TxrServiceImpl service = new TxrServiceImpl();

		// use
		service.transfer(100.00, "1", "2");
		System.out.println();
		service.transfer(100.00, "2", "1");

		// destroy
		service = null;

	}

}
