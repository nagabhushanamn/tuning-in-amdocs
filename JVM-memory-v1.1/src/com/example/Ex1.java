package com.example;

/*
 * 
 * in java , object creation is 2 step process ?
 * 
 * 	step-1 : memory allocation on heap    ==> 'new'
 *  step-2 : initialize that memory with data => 'constructor'
 *  
 *  
 *  obj = new Constructor()
 * 
 */

public class Ex1 {

	public static void main(String[] args) {

		// ---------------------------------------------
		String s1 = "amdocs"; // immutable
		String s2 = "amdocs";

		System.out.println(s1.equals(s2));
		System.out.println(s1 == s2);

		// ---------------------------------------------
		String s3 = "36";
		String s4 = new Integer(36).toString().intern();

		System.out.println(s3.equals(s4));
		System.out.println(s3 == s4);

		s3 = null;
		s4 = null;
		
		// ---------------------------------------------

	}

}
