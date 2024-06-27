package com.learning.threadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ThreadPool {
	
	private BlockingQueue<Runnable> blockingQueue;
	
	// Define Size of Queue and no of threads
	public ThreadPool(int queueSize, int noOfThreads) {
		blockingQueue = new LinkedBlockingDeque<>(queueSize);
		TaskExecutor taskExecutor = null;
		for(int i=0;i<noOfThreads;i++) {
			taskExecutor =new TaskExecutor(blockingQueue);
			Thread taskExecutorThread =new Thread(taskExecutor);
			taskExecutorThread.start();
		}
	}
	
	public void submit(Runnable runnable) {
		blockingQueue.add(runnable);
	}

}
