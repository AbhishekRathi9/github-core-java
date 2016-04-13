package com.home.javaimplementation.stack;

import com.home.javaimplementation.LinkedList.Node;

public class StackUsingLinkedList {
	
	private Node top;
	
	public void push(int item){ //like insert first of linked list
		if(top == null){
			top = new Node(item,null);
		}else{
			Node node = new Node(item,null);
			node.setNext(top);
			top = node;
		}
	}
	
	 	public boolean isEmpty()
	    {
	        return top == null;
	    }  

	 	
	 	public int pop(){ //like delete first of linked list
	 		int value=0;
	 		if (top != null) {
	 			 value = top.getData();
	 			 top=top.getNext();
	 			 return value;
	 		}
	 		return 0;
	 	}
	 	
	 	
	 	public int peep(){
	 		
	 		return top.getData();
	 	}
	 	
	 	public static void main(String[] args) {
	 		StackUsingLinkedList stack1 = new StackUsingLinkedList();
	 		stack1.push(2);
	 		stack1.push(3);
	 		stack1.push(4);
	 		stack1.push(5);
	 		stack1.push(6);
	 		
	 		System.out.println(stack1.pop());
	 		System.out.println(stack1.pop());
	 		System.out.println(stack1.peep());
	 		System.out.println(stack1.pop());
		}
	 	
}
