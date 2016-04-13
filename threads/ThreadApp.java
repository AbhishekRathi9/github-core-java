package com.home.javaimplementation.threads;

import java.util.Scanner;

class Runner extends Thread{
	
	private volatile boolean running = true;

	@Override
	public void run() {
		while(running){
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	void shutdown(){
		running = false;
	}
	
	
}

public class ThreadApp {

	public static void main(String[] args) {
		
		Runner thread1 = new Runner();
		thread1.start();
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		thread1.shutdown();
		
		/*Runner thread2 = new Runner();
		thread2.start();*/
		
	}
}
