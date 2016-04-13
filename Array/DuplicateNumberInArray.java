package com.home.javaimplementation.Array;

import java.util.HashSet;
import java.util.Set;

public class DuplicateNumberInArray {
	
	public static void main(String[] args) {
		
		String[] withDuplicates =  {"one","two","three","one"};
        String[] withoutDuplicates = {"one","two","three"};

        System.out.println("Checking array with duplicate using brute force: ");
        bruteforce(withDuplicates);

        
        System.out.println("Checking array with duplicate using Set and List: ");
        checkDuplicateUsingSet(withDuplicates);


	}

	private static void checkDuplicateUsingSet(String[] withDuplicates) {
		Set<String> set = new HashSet<String>();
		for(String str : withDuplicates){
			if(!set.contains(str)){
				set.add(str);
			}else{
				System.out.println("duplicate is "+str);
			}
		}
		
		
		return ;
	}

	private static void bruteforce(String[] withDuplicates) {
		for(int i=0;i<withDuplicates.length;i++){
			for(int j=withDuplicates.length-1;j>i;j--){
				if(withDuplicates[i].equals(withDuplicates[j])){
					System.out.println("duplicate is "+withDuplicates[i]);
				}
			}
		}
	}

}
