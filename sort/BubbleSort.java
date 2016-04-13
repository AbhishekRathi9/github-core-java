package com.home.javaimplementation.sort;

import java.util.Arrays;

public class BubbleSort {
	
	
	
	public static void main(String[] args) {
		int[] array =  {100,23,43,54,7,99,454,57657,76576,76576,6,21,5};
		
		for(int i =0;i<array.length;i++){
			for(int j=0;j<array.length-i-1;j++){
				if(array[j] > array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(array));
		
	}

}
