package com.home.javaimplementation.numbers;

public class NumberSwapping {
	
	public static void main(String[] args) {
		int num1 = 5;
		int num2= 10;
		int num3 = (num1+num2)-num1;
		num2 = num1;
		num1=num3;
		
		System.out.println(num1);
		System.out.println(num2);
	}

}
