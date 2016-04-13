package com.home.javaimplementation.String;

import java.util.Arrays;

public class TotalCharactersString {
	
	public static void main(String[] args) {
		
		String str = "Abhishek";
		
		
		int[] num = new int[256];
		
		for(char c : str.toCharArray()){
			num[c]=num[c]+1;
		}
		
		for(char c : str.toCharArray()){
			System.out.println(c+"  :" + num[c]);
		}
		
	}

}
