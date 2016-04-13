package com.home.javaimplementation.recursive;

public class Staircase {
	
	static int[] cache = new int[100000000];
	
	public static void main(String[] args) {
		
		int number = 10;
		
		System.out.println(calculate(number)+1);
		
	}

	private static int calculate(int number) {
			if(number < 0)
				return 0;
			if(number == 1)
				return 1;
			else
				if(cache[number] == 0)
					cache[number] =	calculate(number-1)+calculate(number-2)+calculate(number-3);
			return cache[number];
	}

}
