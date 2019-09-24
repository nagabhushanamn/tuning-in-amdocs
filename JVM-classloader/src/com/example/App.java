package com.example;

import com.example.container.WebContainer;

public class App {
	
	public static void main(String[] args) {
		
		WebContainer webContainer=new WebContainer();
		webContainer.process("/sign-in");
		
	}

}
