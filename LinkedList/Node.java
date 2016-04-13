package com.home.javaimplementation.LinkedList;

import java.util.LinkedList;

/**
 * @author a465165
 *
 */
public class Node {
	
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int data;
	
	private Node next;

	
	public Node(int data, Node node) {
		super();
		this.data = data;
		this.next = node;
	}
	
	

	public Node(int data) {
		super();
		this.data = data;
	}

	


	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node node) {
		this.next = node;
	}
	
	/**
     * Display Node's data
     */
    public void displayNode() {
           System.out.print( data + " ");
    }
    
    @Override
    public int hashCode() {
    	// TODO Auto-generated method stub
    	return data;
    }
    
    @Override
    public boolean equals(Object obj) {
    	// TODO Auto-generated method stub
    	Node node = (Node) obj;
    	return  this.data == node.getData();
    }

	
}
