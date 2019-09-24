package com.example;

import java.util.HashMap;
import java.util.Map;

public class JVMOutOfMemoryError {

	private final static int NB_ITERATIONS = 5000000;

	// ~1k
	private final static String LEAKING_DATA_PREFIX = "datadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadata";

	private static Map<String, String> leakingMap;

	static {
		leakingMap = new HashMap<String, String>();
	}

	public static void main(String[] args) {

		try {
			for (int i = 0; i < NB_ITERATIONS; i++) {
				String data = LEAKING_DATA_PREFIX + i;
				leakingMap.put(data, data);
			}
		} catch (Throwable e) {
			if (e instanceof OutOfMemoryError) {
				System.out.println("OutOfMemoryError tiggered! " + e.getMessage() + " [ " + e + " ] ");
			} else {
				System.out.println("Unexpected exception! " + e.getMessage());
			}
		}

	}

}
