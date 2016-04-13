package com.home.javaimplementation.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class Processor implements Runnable{
	
	private int id;
	
	Processor(int id){
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Starting :" + id);	
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed :" + id);
	}
	
	
}

public class ThreadPools {
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		for(int i=0;i<5;i++){
			service.submit(new Processor(i));
		}
		
		service.shutdown();
		
		System.out.println("All tasks subitted");
		
	}

}
