package com.home.javaimplementation.String;

import java.util.ArrayList;

public class StringPermutation {

	public static void main(String[] args) {

		String str = "ab";
		System.out.println(getPerms(str));
	}

	private static ArrayList<String> getPerms(String str) {
		if (str == null) {
			return null;
		}
		ArrayList<String> permutations = new ArrayList<String>();
		if (str.length() == 0) { // base case
			permutations.add("");
			return permutations;
		}
		char first = str.charAt(0); // get the first character
		String remainder = str.substring(1); // remove the 1st character
		System.out.println("first is :"+first+ " remainder is :"+remainder);
		ArrayList<String> words = getPerms(remainder);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				String s = insertCharAt(word, first, j);
				System.out.println("final permutation is :"+s);
				permutations. add(s);
			}
		}
		return permutations;
	}

	public static String insertCharAt(String word, char first, int i) {
		System.out.println("word is :"+word+ "  and first :"+first+ " 	and int i :"+i);
		String start = word.substring(0, i);
		System.out.println("start is :" +start);
		String end = word.substring(i);
		System.out.println("end is :"+end);
		return start + first + end;
	}

}
