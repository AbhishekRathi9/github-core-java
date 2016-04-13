package com.home.javaimplementation.String;

import java.util.HashMap;
import java.util.Map;

public class CompressedString {
	
	public static void main(String[] args) {
		
		
		String str = "Abhishekkkk";
	
		String compressed = compressesBad(str);
		
		System.out.println(compressed);
		
		
	}

	private static String compressesBad(String str) {
		char letter = str.charAt(0);
		StringBuilder sb = new StringBuilder();
		int count = 1;
		
		for( int i =1 ; i < str.length() ; i++){
			if(letter == str.charAt(i)){
				count++;
			}else{
				//sb.append(sb);
				sb.append(letter);
				sb.append(count);
				letter = str.charAt(i);
				count =1;
			}
		}
		//sb.append(sb);
		sb.append(letter);
		sb.append(count);
		
		return sb.toString();
	}

}
