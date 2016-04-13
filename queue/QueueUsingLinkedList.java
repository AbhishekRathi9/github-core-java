package com.home.javaimplementation.queue;

import com.home.javaimplementation.LinkedList.Node;

public class QueueUsingLinkedList {
	
	Node first = null;
	Node last = null;
	
	public void enqueue(int item) {
		if(first == null){
			first = new Node(item);
			first = last;
		}else{
			last.setNext(new Node(item));
			last = last.getNext();
		}
	}
	
	public int dequeue(int item) {
		int value = first.getData();
		first = first.getNext();
		return value;
	}

}
