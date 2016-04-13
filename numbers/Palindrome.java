package com.home.javaimplementation.numbers;

public class Palindrome {
	
	public static void main(String[] args) {
		
		String str = "sasas1";
		String reverse = "";
		/*String reverse = new StringBuilder(str).reverse().toString();
		if(str.equals(reverse.toString())){
			System.out.println("Palindrome");
		}*/
		
		for(int i=str.length()-1; i>=0;i--){
			reverse = reverse + str.charAt(i);
		}
		
		System.out.println(reverse);
	}

}
