package com.learning.threadPool;

import java.util.concurrent.BlockingQueue;

public class TaskExecutor implements Runnable {

	public TaskExecutor(BlockingQueue<Runnable> blockingQueue) {
		// TODO Auto-generated constructor stub
		System.out.println("From TAskExecutor");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	System.out.println("From run()");	
	}

}
