package com.home.javaimplementation.LinkedList;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LinkedListImplementationSecondTime {
	
	public Node head;
	
	 public void insertFirst(int data) {
		 if(head == null){
			 Node n = new Node(data,null);
			 head = n;
		 } else{
			 Node n = new Node(data,head);
			 head = n;
		 }
	 }
	 
	 
	 public void insertLast(int data) {
		 Node temp = head;
		 while(temp.getNext() != null){
			 temp = temp.getNext();
		 }
		 temp.setNext(new Node(data,null));
	 }
	 
	 
	 public void displayLinkedList() {
		 Node temp = head;
		 while(temp != null){
			 System.out.println(temp.getData());
			 temp = temp.getNext();
		 }
	 }
	 
	    public void printRecursively() {
	    	Node temp = head;
	    	displayRecursively(temp);
	    	
	    }

	    void displayRecursively(Node temp){
	    	if(temp==null) {
	    		return;
	    	} else{
	    		System.out.println(temp.getData());
    			temp = temp.getNext();
    			displayRecursively(temp);
	    	}	    	
	    }
	    
	    public void printReverse() {
	    	//Node temp = head;
	    	Node prev = null;
	    	Node current = head;
	    	Node next = current;
	    	while(next != null){
	    		current.setNext(prev);
	    		prev = current;
	    		next = next.getNext();
	    		current=next;
	    		
	    	}
	    	//current.setNext(prev);
	    	head = current;
	    	displayLinkedList();
	    }
	    
	   public void  printReverseRecursively(){
		   head = printReverseRecursively(head);
		   displayLinkedList();
	   }

	   public Node  printReverseRecursively(Node node){
		   if(node == null || node.getNext()==null) {
	    		return node;
	    	} else{
	    		Node remaining = printReverseRecursively(node.getNext());
	    		node.getNext().setNext(node);
	    		node.setNext(null);
	    		return remaining;
	    		
	    	}	
		   
	   }
	   
	   public boolean ifLoopExists(){
		   
		   Node slow = head;
		   Node fast = head;
		   
		   while(fast != null && fast.getNext()!=null){
			   slow = slow.getNext();
			   fast=fast.getNext().getNext();
			   if(slow == fast){
				   return true;
			   }
		   }
		   return false;
	   }
	   
	   public Node getMiddleElement(){
		   Node slow = head;
		   Node fast = head;
		   
		   while(fast != null && fast.getNext()!=null && fast.getNext().getNext()!=null){
			   slow = slow.getNext();
			   fast = fast.getNext().getNext();
		   }
		   
		   return slow;
	   }
	   
	   public void deleteMiddle(Node nodeToBeDeleted){
		   Node temp = head;
		   while(temp.getNext().getData()!=nodeToBeDeleted.getData()){
			   temp=temp.getNext();	
			
			   }
		   temp.setNext(temp.getNext().getNext());
	   }
	   
	   public void removeDuplicates(){
		   Node current = head;
		   Node previous = null;
		   Set<Node> set = new HashSet<Node>();
		   while(current  != null){
			   
			   if(set.add(current)){
				   previous = current;
			   }else{
				   previous.setNext(current.getNext());
			   }
			   current=current.getNext();
		   }
	   }
	   
	   public void removeDuplicatesWithoutCollection(){
		   
		   Node current = head;
		   Node runner = current;
		   
		   while(current != null){
			   while(runner !=null){
				   if(runner.getNext()!=null&&runner.getNext().getData()==current.getData())
					   runner.setNext(runner.getNext().getNext());
				   runner=runner.getNext();
			   }
			   current = current.getNext();
			   runner=current;
			   
		   }
		   
	   }
	   
	   public void listPartion() {
		
		   Node smallerStart = null;
		   Node smallerEnd = null;
		   Node greaterStart = null;
		   Node greaterEnd= null;
		   
		   while(head!=null){
			   if(head.getData() < 10){
				  if(smallerStart == null){
					  smallerStart=head;
					  smallerEnd=smallerStart;
				  }else{
					  smallerEnd.setNext(head);
					  smallerEnd=head;
				  }
			   }else{
				   if(greaterStart == null){
					   greaterStart = head;
					   greaterEnd=greaterStart;
				   }else{
					   greaterEnd.setNext(head);
					   greaterEnd=head;
				   }
			   }
		  
		   head = head.getNext();
		   }
		   //System.out.println(smallerStart.getData());
		   smallerEnd.setNext(null);
		   greaterEnd.setNext(null);
		 
		 /*  while(greaterStart.getNext()!=null){
			   //smaller= smaller.getNext();
			   System.out.println("printing :"+greaterStart.getData());
			   greaterStart=greaterStart.getNext();
		   }*/
		  // smaller.setNext(greater);
		   smallerEnd.setNext(greaterStart);
		   head=smallerStart;

	}


	public void addition(LinkedListImplementationSecondTime link,
			LinkedListImplementationSecondTime link2) {
		
		
		 Node reverseLink = printReverseRecursively(link.head);
		 Node reverseLink2 = printReverseRecursively(link2.head);
		 
		 //link2.displayLinkedList();
		 //link2.displayLinkedList();
	}


	public void findCircularListHead() {
		//displayLinkedList();
		
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.getNext() != null){
			slow = slow.getNext();
			fast=fast.getNext().getNext();
			
			if(slow == fast){
				System.out.println("circular list");
				System.out.println(slow.getData());
				break;
			}
		}
			
			fast = head;
			
			//System.out.println(fast.getData());
			//System.out.println(slow.getData());
			
			while(fast!=slow){
				fast = fast.getNext();
				slow = slow.getNext();
			}
			System.out.println("head of the circle is "+slow.getData());
			
		}


	public void isListPalindrome() {

		Node slow = head;
		Node fast = head;
		
		Stack<Node> stack = new Stack<Node>();
		stack.add(slow);
		while(fast != null && fast.getNext()!= null && fast.getNext().getNext()!= null){
			slow = slow.getNext();
			stack.add(slow);
			fast=fast.getNext().getNext();
		}
		
		if(fast.getNext() == null){
			stack.pop();
		}
		
	
		
		while(slow.getNext()!=null){
			Node nextVal = stack.pop();
			if(nextVal.getData() != slow.getNext().getData()){
				System.out.println("Not Plaindrome");
			}
			slow = slow.getNext();
			
		}
		
	}
		
		
		
	}

