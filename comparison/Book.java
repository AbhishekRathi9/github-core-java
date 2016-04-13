package com.home.javaimplementation.comparison;

public class Book implements Comparable<Book>{
	
	 String title;
	   String author;
	   double price;
	   String publisher;

	     public void setTitle(String title){
	       this.title=title;
	     }

	    public String getTitle(){
	      return title;
	    }

	   public void setAuthor(String author){
	     this.author=author;
	   }

	   public String getAuthor(){
	    return author;
	   }

	   public void setPrice(double price){
	    this.price=price;
	   }

	   public double getPrice(){
	   return price;
	   }

	   public void setPublisher(String publisher){
	    this.publisher=publisher;
	  }

	  public String getPublisher(){
	   return publisher;
	  }

	public int compareTo(Book book){

	     if(book == null){
	       throw new NullPointerException("Book passed is null!"); 
	    }

	    if(book.getAuthor().equals(this.getAuthor())){  /*Most significant field*/
	       
	    
	    	 if(book.getAuthor().equals("Completed")){
	    		 
		    	 return -1;
		    }else{
		    	return (int)(this.getPrice()-book.getPrice());
		    }
	     }
	    
	   
	     else
	          return book.getAuthor().compareTo(this.getAuthor());
	       
	  }

}
