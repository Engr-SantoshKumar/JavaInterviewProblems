package _02_CTCI_Questions.sortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _10_02_group_anagrams {
	
	public static ArrayList<ArrayList<String>> groupAnagram(String [] WordsArray){
		
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        if(WordsArray == null || WordsArray.length == 0){
            return result;
        }
		Map<String, ArrayList<String>> hmap = new HashMap<String, ArrayList<String>>();
		
		for(String word : WordsArray){
			char[] wordChars = word.toCharArray();
			Arrays.sort(wordChars);
			//String sortedWord = new String(wordChars);
			String sortedWord = String.valueOf(wordChars); // converting to string
			if(!hmap.containsKey(sortedWord)){
				hmap.put(sortedWord, new ArrayList<String> ());
			}
			
			hmap.get(sortedWord).add(word);
		}
		for(String key : hmap.keySet()){
			result.add(hmap.get(key));
		}
		return result;
	}
	
	// using array of 26 size 
	public static List<List<String>> groupAnagramsUsingArray(String[] strs) {
	    List<List<String>> result = new ArrayList<List<String>>();
	 
	    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

	    for(String str: strs){
	        char[] arr = new char[26];
	        for(int i=0; i<str.length(); i++){
	            arr[str.charAt(i)-'a']++;   // this will put a--> 0; b--> 1 and so on
	        }
	        
	        String nKey = new String(arr);
	 
	        if(map.containsKey(nKey)){
	            map.get(nKey).add(str);
	        }else{
	            ArrayList<String> al = new ArrayList<String>();
	            al.add(str);
	            map.put(nKey, al);
	        }
	    }
	 
	    result.addAll(map.values());
	 
	    return result;
	}
	
	
	

	public static void main(String[] args) {
		String[] names = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagram(names));
		System.out.println(groupAnagramsUsingArray(names));
	}

}
