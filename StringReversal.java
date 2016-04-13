package com.home.javaimplementation.String;

public class StringReversal {

	public static void main(String[] args) {

		String name="Abhishek"; 
		iterativeReversal(name);
		System.out.println(recursiveReversal(name));
	}

	
	private static String  recursiveReversal(String name) {
		if(name.length()==1){
			return name;
		}else{
			return name.charAt(name.length()-1)+recursiveReversal(name.substring(0, name.length()-1));
		}
	}


	private static void iterativeReversal(String name) {
		String reverse="";  
		for(int i=name.length()-1;i>=0;i--)  
		{  
			reverse=reverse+name.charAt(i);  
		}  
		System.out.println(reverse);  
	}

}
