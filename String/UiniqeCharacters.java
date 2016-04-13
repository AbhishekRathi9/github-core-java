package com.home.javaimplementation.String;

import java.util.HashSet;
import java.util.Set;

public class UiniqeCharacters {

	public static void main(String[] args) {


		String s = "Abhishek";

		char[] array = s.toCharArray();
		//USing HashSet o(n)
		/*Set<Character> set = new HashSet<Character>();
		for( char c : array) {
			if(!set.add(c)){
				System.out.println("duplicate char is :"+c);
			}
		}*/

		// Using Brute force.. O(n2)
		/*for(int i=0; i<array.length;i++){
			for(int j=i+1;j<array.length;j++){
				if(array[i]==array[j]){
					System.out.println("duplicate char is :"+array[i]);
				}
			}
		}*/

		//Elegant way O(n)
		System.out.println(isStringUnique(s));



	}

	private static boolean isStringUnique(String s) {
		if(s.length() > 256) return false;

		boolean[] charSet = new boolean[256];
		for(char c : s.toCharArray()){
			if(charSet[c]){
				return false;
			}
			charSet[c]=true;
		}
		return true;
		
	
	}

}
