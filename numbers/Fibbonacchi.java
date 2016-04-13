package com.home.javaimplementation.numbers;

import java.util.Arrays;
import java.util.List;

public class Fibbonacchi {
	private static  int[] cache = new int[1000];
	
	public static void main(String[] args) {
		Fibbonacchi fib = new Fibbonacchi();
		List<Integer> numbers = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);
		for(int num : numbers){
			System.out.println( fib.printFibonacchi(num));
		}
		
		
	}

	private  int printFibonacchi(int number) {
		
		if(cache[number] != 0){
			return cache[number];
		}
		if(number == 0 || number == 1){
			return number;
		}else{
			int res =  printFibonacchi(number-1)+printFibonacchi(number-2);
			cache[number] = res;
			return res;
		}
		
	}

}
