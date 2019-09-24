package com.example.component;

import com.example.container.RequestMapping;

public class WebComponent {
	
	private static String staVar="...";
	
	static {
		System.out.println("WebComponent - static block...");
	}

	@RequestMapping(url = "/sign-in")
	public void login() {
		System.out.println("login...");
	}
	@RequestMapping(url = "/sign-up")
	public void register() {
		System.out.println("register..");
	}
	
}
