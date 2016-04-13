package com.home.javaimplementation.threads;

public class ConsumerProducerWaitNotifyDemo {
	
public static void main(String[] args) throws Exception {
	
	final ConsumerProducerWaitNotify processor = new ConsumerProducerWaitNotify();
	
	Thread t1 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			try {
				processor.produce();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	});
	
	Thread t2 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			try {
				processor.consume();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	});
	
	t1.start();
	t2.start();
	
	t1.join();
	t2.join();
		
	}
	

}
