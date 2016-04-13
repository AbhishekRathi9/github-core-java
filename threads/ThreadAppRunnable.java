package com.home.javaimplementation.threads;

public class ThreadAppRunnable {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runner1());
		thread1.start();
	}
	


}

class Runner1 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println("Hello :" +i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
