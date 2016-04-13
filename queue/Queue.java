package com.home.javaimplementation.queue;

public class Queue {
	
	private int[] items = new int[5];
	private int head = -1;
	private int tail = -1;
	private int numOfItems = 0; // this field makes the implementation easy, but we can implement even without it.
	
	public Queue() {}
	
	public Queue(int size) {
		this.items = new int[size];
	}
	
	public boolean isFull() {
		return numOfItems == items.length;
	}

	public boolean isEmpty() {
		return numOfItems == 0;
	}
	
	public void enqueue(int item) {
		if (isFull())
			throw new RuntimeException("Queue is full");
		if (tail == items.length-1) // deal with circular case
			tail = -1;
		items[++tail] = item;
//		if (head == -1) head++;
		numOfItems++; // add 1 to the item count
	}
	
	public int dequeue(int item) {
		numOfItems--;
		return items[++head];
	}
	

}
