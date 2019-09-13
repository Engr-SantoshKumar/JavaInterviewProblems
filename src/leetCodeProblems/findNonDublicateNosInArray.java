package leetCodeProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class findNonDublicateNosInArray {

	public static void main(String[] args) {

		int[] numbers = {1,0,3,4,2,1,2,4,0,6,7,8,9};
		duplicate(numbers);
		

	}
	
	public static void duplicate(int[] s) {
		System.out.println("Duplicate elements from array using hash table");
		
		Map<Integer, Integer> charAndCount = new HashMap<Integer, Integer>();
		
		for (int c : s) { 
			Integer count = charAndCount.get(c); 

			charAndCount.put(c, count!=null? count+1 : 1);
					
			}
		System.out.println("Character and there count :");
		System.out.println(charAndCount);
		
		// Print duplicate elements 
		Set<Entry<Integer, Integer>> entrySet = charAndCount.entrySet(); 
		
		for (Entry<Integer, Integer> DuplicEntry : entrySet) { 
			if (DuplicEntry.getValue() == 1) { 
				System.out.println("Duplicate element from map : " + DuplicEntry.getKey()+ " and its Value is " + DuplicEntry.getValue()); 
				} 
			}
	}

}
