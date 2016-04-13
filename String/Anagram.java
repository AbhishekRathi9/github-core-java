package com.home.javaimplementation.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
	
	public static void main(String[] args) {
		
	
	
	String s1 = "schoolmastefdfdsfr";
	String s2 = "schoolmastefdfdsfr";
	
	char[] c1 = s1.toCharArray();
	char[] c2 = s2.toCharArray();
	
	Arrays.sort(c1);
	Arrays.sort(c2);
	
	System.out.println(Arrays.equals(c1, c2));
	
	Map<Character, Integer> lettersInWord1 = new HashMap<Character, Integer>();
	
	for(char c3 : c1){
		lettersInWord1.put(c3, lettersInWord1.containsKey(c3)?lettersInWord1.get(c3)+1:1);
	}
	
	for(char c4 : c2){
		lettersInWord1.put(c4, lettersInWord1.containsKey(c4)?lettersInWord1.get(c4)-1:1);
	}
	
	
	System.out.println(lettersInWord1);
	
	System.out.println(isAnagram(s1,s2));
	}

	private static boolean isAnagram(String s1, String s2) {
		// TODO Auto-generated method stub
		if(s1.length() != s2.length())
			return false;
		
		int[] letters = new int[256];
		
		for(char c : s1.toCharArray()){
			letters[c]++;
		}
		
		for(char c : s2.toCharArray()){
			if(--letters[c] < 0)
				return false;
		}
		return true;
		
	}
	
	

}
