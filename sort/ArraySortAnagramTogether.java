package com.home.javaimplementation.sort;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySortAnagramTogether {
	
	

	public static void main(String[] args) {
		
		 String[] strArray = {"abcd","abc","abce", "acd","abdc","abc"};
		 
		 Arrays.sort(strArray,new AnagramComparator());
		System.out.println(Arrays.toString(strArray));
		
	}

}

 class AnagramComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return sort(o1).compareTo(sort(o2));
	}

	private String sort(String o1) {
		char[] c = o1.toCharArray();
		 Arrays.sort(c);
		 return new String(c);
	}
	
	
	
}
