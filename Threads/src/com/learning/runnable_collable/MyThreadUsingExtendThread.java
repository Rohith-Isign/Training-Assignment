package com.learning.runnable_collable;

public class MyThreadUsingExtendThread extends Thread{
	
	public void run() {
		System.out.println("Executing from MyThread extending Thread class");
	}
	
	public static void main(String[] args) {
		MyThreadUsingExtendThread thread =new MyThreadUsingExtendThread();
		thread.start();
	}

} 
