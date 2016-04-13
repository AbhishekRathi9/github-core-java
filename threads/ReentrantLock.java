package com.home.javaimplementation.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ReentrantLock {
	
	private static int count;
	private static Lock lock = new java.util.concurrent.locks.ReentrantLock();
	private static Condition condition = lock.newCondition();
	
	private static void increment(){
		for(int i=0;i<10000;i++){
			count++;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		Thread t1 = new Thread (new Runnable() {
			
			@Override
			public void run() {
				try {
					firstThread();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		Thread t2 = new Thread (new Runnable() {
			
			@Override
			public void run() {
				secondThread();
				
			}
		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		finished();
	}
	
	private static void firstThread() throws Exception {
		lock.lock();
		condition.await();
		try{
			increment();
		}finally{
			lock.unlock();
		}
	}
	
	private static void secondThread() {
		lock.lock();
		condition.signal();
		try{
			increment();
		}finally{
			lock.unlock();
		}
	}
	
	private static void finished() {
		System.out.println("count is :"+count);

	}

}
