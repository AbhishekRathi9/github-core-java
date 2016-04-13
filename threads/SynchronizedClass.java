package com.home.javaimplementation.threads;

public class SynchronizedClass {
	
	private int count;
	
	public static void main(String[] args) throws Exception {
		SynchronizedClass sync = new SynchronizedClass();
		sync.doWork();
	}

	private void doWork() throws Exception {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<1000;i++){
					synchronized(SynchronizedClass.class){
						count++;
					}
					
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<1000;i++){
				synchronized(SynchronizedClass.class){
					count++;
				}
				}
				
			}
		});
		
		
		
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(count);
		
	}

}
