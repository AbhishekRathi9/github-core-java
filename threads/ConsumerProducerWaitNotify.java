package com.home.javaimplementation.threads;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class ConsumerProducerWaitNotify {
	
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private final int LIMIT = 10;
	private Object lock = new Object();
	
	
	
	public void produce() throws Exception{
		int value = 0;
		while(true){
			synchronized (lock) {
				while(list.size() >= LIMIT){
					lock.wait();
				}
					list.add(value++);
					lock.notify();
			}
			
		}
		
	}
	
	public void consume() throws Exception{
		
	while(true){
		synchronized (lock) {
				while(list.size() == 0){
					lock.wait();
				}
				System.out.println("list size "+list.size());
				int value = list.removeFirst();
				System.out.println("value is "+value);
				lock.notify();
			
			
		}
	}
	}

}
