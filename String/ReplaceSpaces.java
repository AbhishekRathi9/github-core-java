package com.home.javaimplementation.String;

import java.util.Arrays;

public class ReplaceSpaces {
	
	public static void main(String[] args) {
		String str = "Mr John Smith   ";
	char[] chararray = str.toCharArray();
	
	StringBuilder sb = new StringBuilder();
	for(char c : chararray){
		if(c == ' '){
			sb.append("%20");
		}else{
			sb.append(c);

		}
	}
	System.out.println(sb);
	
	String s = "A";
	System.out.println(s.length());
	
	}
	
	

}
