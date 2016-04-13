package com.home.javaimplementation.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.hssf.record.formula.functions.Rand;

public class Worker {
	
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	
	private Random random = new Random();
	
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	
	
	public void stage1(){
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (lock1) {
			list1.add(random.nextInt(100));
		}
		
	}
	
	public void stage2(){
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		synchronized (list2) {
			list2.add(random.nextInt(100));

		}
		
	}
	
	
	public void process(){
		for(int i=0;i<1000;i++){
			stage1();
			stage2();
		}
	}
	
	public void main() {
		System.out.println("Starting.....");
		Long start = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				process();
				
			}
		});
		
		t1.start();
		
Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				process();
				
			}
		});
		
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Long end = System.currentTimeMillis();
		
		System.out.println("Time Taken :"+ (end - start));
		
		System.out.println("List1: " +list1.size());
		System.out.println("List2: " +list2.size());
	}

}
