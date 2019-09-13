package leetCodeProblems;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 */

/**
 * @author U494321
 *
 */
public class findingDuplicatesUsingHashMap {
	
	public static void main(String[] args) {

		duplicate("santoshkumar");
	}
	
	public static void duplicate(String s) {
		System.out.println("Duplicate elements from array using hash table");
		
		Map<Character, Integer> charAndCount = new HashMap<Character, Integer>();
		
		for (char c : s.toCharArray()) { 
			Integer count = charAndCount.get(c); 
			
			/*if (count == null) { 
				charAndCount.put(c, 1); 
				} else { 
					charAndCount.put(c, ++count); 
					} */
			charAndCount.put(c, count!=null? count+1 : 1);
					
			}
		System.out.println("Character and there count :");
		System.out.println(charAndCount);
		
		// Print duplicate elements 
		Set<Entry<Character, Integer>> entrySet = charAndCount.entrySet(); 
		
		for (Entry<Character, Integer> DuplicEntry : entrySet) { 
			if (DuplicEntry.getValue() > 1) { 
				System.out.println("Duplicate element from map : " + DuplicEntry.getKey()+ " and its Value is " + DuplicEntry.getValue()); 
				} 
			}
	}
	
}

		
    

	

