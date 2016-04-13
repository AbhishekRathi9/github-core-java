package com.home.javaimplementation.threads;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CountDownLatches {
	
	public static void main(String[] args) {
		
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		for(int i =0;i<3;i++){
			service.submit(new Processor1(latch));
		}
		
			
			
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("completed");
	}
	
	

}

class Processor1 implements Runnable{

	private CountDownLatch latch;
	
	
	public Processor1(CountDownLatch latch) {
		super();
		this.latch = latch;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("Started");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
		
		
		
	}
	
}
