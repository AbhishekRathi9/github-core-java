package com.home.javaimplementation.LinkedList;

import java.util.LinkedList;

public class LinkedListImplementation {
	
	 private Node head; // ref to first link on list
	 
	 
	    /**
	     * Insert New Node at first position
	     */
	    public void insertFirst(int data) {
	    	  Node newNode = new Node(data); //Creation of New Node.
	           newNode.setNext(head);   //newLink ---> old first
	           this.head=  newNode;//first ---> newNode
	    }
	    
	    public void insertLast(int data) {
	    	 Node newNode = new Node(data);
	    	Node temp = head;
	    	while(temp.getNext() != null){
	    		temp = temp.getNext();
	    	}
	    	temp.setNext(newNode);
	    }
	    
	    public void displayLinkedList() {
	           System.out.print("Displaying LinkedList [first--->last]: ");
	           Node temp = head;
	           while(temp != null){
	        	  temp.displayNode();
	        	  temp = temp.getNext();
	           }
	    }
	    
	    public void printRecursively() {
	    	 Node temp = head;
	    	 displayLinkedListRecursively(temp);
	    }
	    
	    public void displayLinkedListRecursively( Node temp) {
	    	 if(temp.getNext() == null){
	        	  temp.displayNode();
	          }else{
	        	  temp.displayNode();
	        	  temp = temp.getNext();
	        	  displayLinkedListRecursively(temp);
	          }
	    }
	    
	    
	    public void printReverse() {
	    	 Node temp = head;
	    	 printReverseRecursively(temp);
	    	 //temp.displayNode();
	    }
	    
	    
	    private void printReverseRecursively(Node temp) {
	    	 if(temp.getNext() == null){
	    		 temp.displayNode();
	          }else{
	        	  //temp = temp.getNext();
	        	  printReverseRecursively(temp.getNext());
	        	  temp.displayNode();
	          }
		}

		public void deleteFirst() {
	    	this.head = head.getNext();
	    }
	    
	    
	    public void deleteLast() {
	    	Node current = head;
	    	Node previous = null;
	    	
	    	while(current.getNext() != null){
	    		previous = current;
	    		current = current.getNext();
	    	}
	    	previous.setNext(null);
	    }
	    
	    public void size() {
	    	Node temp = head;
	    	int size = 0;
	    	while(temp != null){
	    		temp = temp.getNext();
	    		size++;
	    	}
	    	System.out.println(size);
	    }
	    
	    public void linkReversal() {
	    	Node current = head;
	    	Node previous = null;
	    	Node next = current.getNext();
	    	
	    	while(current.getNext()!=null){
	    		current.setNext(previous);
	    		previous = current;
	    		current = next;
	    		next = current.getNext();
	    	}
	    	current.setNext(previous);
	    	head=current;
	    }
	 
	    public void linkReverseRecursively() {
	    	 Node temp = head;
	    	 linkReversalRecursively(temp);
	    	 //temp.displayNode();
	    }
	    
	    public void linkReversalRecursively(Node temp) {
	    	 if(temp.getNext() == null){
	    		 head = temp;
	          }else{
	        	  //temp = temp.getNext();
	        	  linkReversalRecursively(temp.getNext());
	        	  temp.getNext().setNext(temp);
	        	  temp.setNext(null);
	          }
	    }
	    

}
