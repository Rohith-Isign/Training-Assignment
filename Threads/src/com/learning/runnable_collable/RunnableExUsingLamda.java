package com.learning.runnable_collable;

public class RunnableExUsingLamda {
	 public static void main(String[] args) {
	        Runnable task = () -> {
	            System.out.println("Executing task in Runnable");
	        };

	        Thread thread = new Thread(task);
	        thread.start();
	    }

}
