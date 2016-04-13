package com.home.javaimplementation.comparison;

import java.util.Arrays;

public class BookComparision {
	
	 public static void main(String args[]){
	       
	        Book book1 = new Book();        
	        book1.setAuthor("Completed");
	        book1.setTitle("Title A");
	        book1.setPrice(225.00);
	        
	        Book book2 = new Book();        
	        book2.setAuthor("Completed");
	        book2.setTitle("Title B");
	        book2.setPrice(125.00);
	        
	        
	        Book book3 = new Book();        
	        book3.setAuthor("Completed");
	        book3.setTitle("Title B");
	        book3.setPrice(125.00);
	        
	        Book book4 = new Book();        
	        book4.setAuthor("Completed");
	        book4.setTitle("Title A");
	        book4.setPrice(200.00);
	        
	        
	        Book book5 = new Book();        
	        book5.setAuthor("Not Started");
	        book5.setTitle("Title C");
	        book5.setPrice(125.00);
	        
	        Book book6 = new Book();        
	        book6.setAuthor("Not Started");
	        book6.setTitle("Title B");
	        book6.setPrice(125.00);
	        
	        Book book7 = new Book();        
	        book7.setAuthor("Not Started");
	        book7.setTitle("Title B");
	        book7.setPrice(400.00);
	        
	       /* An array containing Books*/
	        Book[] bookArray = new Book[7];
	        bookArray[0]=book1;
	        bookArray[1]=book2;
	        bookArray[2]=book3;
	        bookArray[3]=book4;
	        bookArray[4]=book5;
	        bookArray[5]=book6;
	        bookArray[6]=book7;
	        
	        System.out.println("Sorted Books:");
	       
	        Arrays.sort(bookArray);

	        for(int i=0;i<=6;i++){
	        System.out.print("Author:"+bookArray[i].getAuthor()+"        ");
	        System.out.print("Title:"+bookArray[i].getTitle()+"        ");
	        System.out.println("Price:"+bookArray[i].getPrice());

	        }        
	   }

}
