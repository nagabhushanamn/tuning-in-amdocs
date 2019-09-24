package com.example;

import java.util.HashMap;
import java.util.Map;

public class JVMVerboseGC {

	private static Map<String, String> mapContainer = new HashMap<String, String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String stringDataPrefix = "stringDataPrefix";

		// Load Java Heap with 3 M java.lang.String instances
		for (int i = 0; i < 3000000; i++) {
			String newStringData = stringDataPrefix + i;
			mapContainer.put(newStringData, newStringData);
		}

		System.out.println("MAP size: " + mapContainer.size());
		System.gc(); // Explicit GC!

		// Remove 2 M out of 3 M
		for (int i = 0; i < 2000000; i++) {
			String newStringData = stringDataPrefix + i;
			mapContainer.remove(newStringData);
		}

		System.out.println("MAP size: " + mapContainer.size());
		System.gc();
		System.out.println("End of program!");
		
		

	}

}
