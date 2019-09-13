package _02_CTCI_Questions.recursion_DynamicPrograming;

import java.util.ArrayList;
import java.util.HashMap;

public class _08_08_Permutations_with_Duplicates {
	
	static ArrayList<String> printPermutaion (String s){
		
		ArrayList<String> result = new ArrayList<String>();
		HashMap<Character, Integer> map = getCharCount(s);
		allPermutations(map, "", s.length(), result );
		return result;
		
	}
	
	static void allPermutations(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result){
		  if(remaining == 0){
			  result.add(prefix);
			  return;			  
		  }
		  
		  for(char c : map.keySet()){
			  int count = map.get(c);
			  if(count > 0){
				  map.put(c, count-1);
				  prefix = prefix + c;
				  allPermutations(map, prefix, remaining-1, result );
				  map.put(c, count);
			  }
		  }	  
	}
	

	//find the count of each char in string
	static HashMap<Character, Integer> getCharCount(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for(char c : s.toCharArray()){
				Integer count = map.get(c);
				map.put(c, count != null? count+1 : 1 );
			}
		return map;
	}

	public static void main(String[] args) {
		String s = "aab";
		ArrayList<String> result = printPermutaion(s);
		for(String str : result){
			System.out.println(str);
		}
		
	}

}
