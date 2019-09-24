package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/*
 * 
 *  how many threads we can create ?
 *  
 *  
 *  
 * task(s)
 * -----------
 *  
 *  - computation
 *  - io
 * 
 *  -------------------------------------------
 *  
 *                         # of cpus e.g 8
 *  # of threads    <=     ---------------
 *                         blocking-factor
 *  
 *  
 *   0 < blocking-factor < 1
 *   
 *       e.g 0.5
 *       
 *       
 *  -------------------------------------------     
 *  
 */

public class Ex6 {

	public static void main(String[] args) {
		
		ExecutorService executorService=Executors.newCachedThreadPool();
		ForkJoinPool forkJoinPool=new ForkJoinPool();
		
	}

}
