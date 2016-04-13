package com.home.javaimplementation.numbers;

public class PrimeNumber {
	
	public static void main(String[] args) {
		int num = 10;
		int lastIndex = num/2;
		for( int i=3; i<=lastIndex; i++){
			if(num%i == 0){
				System.out.println("number is not prime");
				break;
			}
		}
	}

}
