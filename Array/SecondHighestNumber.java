package com.home.javaimplementation.Array;

import java.net.URL;

public class SecondHighestNumber {
	
	URL url = getClass().getResource("ListStopWords.txt");
	
	public static void main(String[] args) {
		
	
		int[] numbers =  {1111,2,3,4,5,4,1112,4,5,78,7,77,76,745,676,77,11112};
		int max = numbers[0];
		int secHighest = numbers[0];
		for(int number : numbers){
			if(max<number){
				secHighest = max;
				max = number;
			} else if(secHighest < number){
				secHighest =  number;
			}
		}
		System.out.println(max);
		System.out.println(secHighest);
	}



}
