package com.home.javaimplementation.Array;

public class HighestNumber {
	
	public static void main(String[] args) {
		int[] numbers =  {2,3,4,5,4,1112,4,5,78,7,77,76,745,676,77};
		int highest=numbers[0];
		int secHighest=numbers[0];
		
		for(int n : numbers){
			if(n>highest){
				secHighest = highest;
				highest=n;
			} else if (n>secHighest){
				secHighest=n;
			}
		}
		System.out.println(highest);
		System.out.println(secHighest);
	}

}
