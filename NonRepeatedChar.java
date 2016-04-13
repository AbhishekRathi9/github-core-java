package com.home.javaimplementation.String;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class NonRepeatedChar {
	
	public static void main(String[] args) {
		
		String str = "Abhishek";
		char[] array = str.toCharArray();
		
		Set<Character> set = new LinkedHashSet<Character>();
		for(char c : array){
			if(!set.add(c)){
				System.out.println("character is "+c);
			}
		}
		
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		for(char c : array){
			map.put(c, map.containsKey(c)?map.get(c)+1:1);
		}
		System.out.println(map);
	}
	
		

}
