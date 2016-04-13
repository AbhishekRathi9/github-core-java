package com.home.javaimplementation.Array;

import java.util.Arrays;
import java.util.List;

public class MissingNumber {
	
	public static void main(String[] args) {
		Integer[] array1 =  {1,2,3,4,5};
		Integer[] array2 =  {2,3,1,0,5};
		
		List<Integer> list = Arrays.asList(array1);
		for(int i : array2){
			if(!list.contains(i)){
				System.out.println("missing element is "+i);
			}
		}
	}

}
