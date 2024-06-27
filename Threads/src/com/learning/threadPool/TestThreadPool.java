package com.learning.threadPool;

public class TestThreadPool {
	
	public static void main(String[] args) {
		ThreadPool threadPool = new ThreadPool(10, 2);
		for(int taskNumber=0; taskNumber<=5; taskNumber++) {
			final String str= new String("abcd_" + taskNumber);
			threadPool.submit(() -> {
				String msg ="Task " + Thread.currentThread().getName()+ " is running"+str;
				System.out.println(msg);
				String msg1 ="ThreadLocal "+ Thread.currentThread().getName()+ " is running"+str;
				System.out.println(msg1);
			});
		}
	}
}
