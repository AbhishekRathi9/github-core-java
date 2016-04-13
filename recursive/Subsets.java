package com.home.javaimplementation.recursive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Required;

public class Subsets {
	
	static List<Integer> required = new ArrayList<Integer>();
	public static void main(String[] args) {
		
		Set<Integer> set = new HashSet<Integer>();
		
		
		set.add(1);
		set.add(2);
		//set.add(3);
		
		System.out.println("Final result id :"+powerSet(set));
	}

	/*List<ArrayList<Integer>> allSubsets;
	if(set.size() == index){
		allSubsets = new ArrayList<ArrayList<Integer>>();
		allSubsets.add(new ArrayList<Integer>());
	}
	else{
		allSubsets = print(set,index+1);
		int item = set.get(index);
		ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
		for (ArrayList<Integer> subset : allSubsets) {
			ArrayList<Integer> newsubset = new ArrayList<Integer>();
			newsubset.addAll(subset); //
			newsubset.add(item);
			moresubsets.add(newsubset);
		}
		allSubsets.addAll(moresubsets);
	}
 return allSubsets;
}*/
	private static Set<Set<Integer>> powerSet(Set<Integer> originalSet) {
	
		
		 Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
	        if (originalSet.isEmpty()) {
	            sets.add(new HashSet<Integer>());
	            return sets;
	        }
	        List<Integer> list = new ArrayList<Integer>(originalSet);
	        Integer head = list.get(0);
	        //System.out.println("head is :"+head);
	        Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size()));
	        System.out.println("head is :"+head+ " And rest is :"+rest);
	        for (Set<Integer> set : powerSet(rest)) {
	        	System.out.println("set is :"+set);
	            Set<Integer> newSet = new HashSet<Integer>();
	            newSet.add(head);
	           newSet.addAll(set);
	            sets.add(newSet);
	           sets.add(set);
	        }
	        return sets;
	        }

}
