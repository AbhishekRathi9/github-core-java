package com.home.javaimplementation.LinkedList;

public class LinkedListImplementationSecondTimeDemo {
	
	public static void main(String[] args) {
		
		LinkedListImplementationSecondTime link = new LinkedListImplementationSecondTime();
		//link.insertFirst(7);
		//link.insertLast(8);
		//link.insertLast(15);
		//link.insertFirst(5);
		//link.insertFirst(4);
		//link.insertFirst(20);
		//link.insertFirst(21);
		link.insertFirst(0);
		link.insertLast(1);
		//link.insertLast(2);
		//link.insertLast(3);
		link.insertLast(2);
		link.insertLast(1);
		link.insertLast(0);
		
		
		link.displayLinkedList();
	//link.printRecursively();
		
		//link.printReverseRecursively();
	//System.out.println(link.getMiddleElement().getData());
	//Node node = new Node(6,null);
	//link.deleteMiddle(node);
	//link.displayLinkedList();
	
		//link.displayLinkedList();
	//link.removeDuplicatesWithoutCollection();
	//link.listPartion();
	//link.displayLinkedList();
	//link.printReverseRecursively();
	
	
	//LinkedListImplementationSecondTime link2 = new LinkedListImplementationSecondTime();
	//link2.insertFirst(5);
	//link2.insertFirst(8);
	//link2.insertLast(9);
	//System.out.println("\n");
	//link2.displayLinkedList();
	//link2.printReverseRecursively();
	//addition(link,link2);
		//reverse(link);
		
		
	/*	LinkedListImplementationSecondTime circularList = new LinkedListImplementationSecondTime();
		
		Node node1 = new Node(5);
		Node node2 = new Node(8);
		Node node3 = new Node(10);
		Node node4 = new Node(12);
		Node node5 = new Node(14);
		Node node6 = new Node(16);
		Node node7 = new Node(18);
		Node node8 = new Node(20);
		Node node9 = new Node(22);
		Node node10 = new Node(24);
		circularList.head=node1;
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(node7);
		node7.setNext(node8);
		node8.setNext(node9);
		node9.setNext(node10);
		node10.setNext(node5);
		
		//circularList.displayLinkedList();
		
		circularList.findCircularListHead();*/
		
		link.isListPalindrome();
	}

	private static void reverse(LinkedListImplementationSecondTime link) {
		Node head = null;
		Node temp = link.head;;
		link.head = doReversal(temp);
		link.displayLinkedList();
		
	}

	private static Node doReversal(Node temp) {
		if(temp.getNext()==null){
			return temp;
		}
			Node remaining = doReversal(temp.getNext());
			temp.getNext().setNext(temp);
			 temp.setNext(null);
			 return remaining;
		
		 
	}

	private static void addition(LinkedListImplementationSecondTime link,
			LinkedListImplementationSecondTime link2) {
		
		link.printReverseRecursively();
		link2.printReverseRecursively();
		
		Node reverseLink = link.head;
		Node reverseLink2 = link2.head;
		Node node = null;
		Node requiredList = null;
		int cary =0;
		while(reverseLink!=null && reverseLink2!=null){
			int sum = cary+reverseLink.getData() + reverseLink2.getData();
			int modulus = sum%10;
			cary = sum/10;
			if(node == null){
				 node = new Node(modulus);
				requiredList = node;
			} else{
				 node.setNext(new Node(modulus));
				 node = node.getNext();
				//requiredList.setNext(node);
			}
				
			
			 reverseLink = reverseLink.getNext();
			reverseLink2 = reverseLink2.getNext();
		}
		node.setNext(new Node(cary));
		node = node.getNext();
		node.setNext(null);
		System.out.println("\n");
		while(requiredList!=null){
			System.out.println(requiredList.getData());
			requiredList = requiredList.getNext();
		}
		/*LinkedListImplementationSecondTime link3 = new LinkedListImplementationSecondTime();
		link3.head = requiredList;
		link3.displayLinkedList();*/
	}

	
}
