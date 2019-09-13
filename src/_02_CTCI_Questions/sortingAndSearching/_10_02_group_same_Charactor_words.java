package _02_CTCI_Questions.sortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _10_02_group_same_Charactor_words {
	
	// Method one
	static List<List<String>> groupAnagramsUsingSort(String [] wordsList){
		
		// created a list of list to store same char words together
		List<List<String>> resultList = new ArrayList<List<String>>();
		
		HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();
		
		for(String word : wordsList){
			
			char [] wordChars = word.toLowerCase().toCharArray();
			Arrays.sort(wordChars);
			String wordKey = String.valueOf(wordChars);
			
			if(!hashMap.containsKey(wordKey)){
				ArrayList<String> sameCharWords = new ArrayList<String>();
				sameCharWords.add(word);
				hashMap.put(wordKey,sameCharWords);
			}else{
				hashMap.get(wordKey).add(word);

			}
		}
		
		resultList.addAll(hashMap.values());
		return resultList;
		
	}
	
	//Method Two
	static List<List<String>> groupAnagramByArray(String [] wordList){
		List<List<String>> result = new ArrayList<List<String>>();
		HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();
		
		for(String word : wordList){
			char [] alphabets = new char[26];
			for(int i =0; i<word.length(); i++){
				alphabets[word.toLowerCase().charAt(i)-'a'] ++;
			}
			
			String wordKey = new String(alphabets);
			//System.out.println(wordKey);
			
			if(hashMap.containsKey(wordKey)){
				hashMap.get(wordKey).add(word);
			}else{
				ArrayList<String> sameCharWords = new ArrayList<String>();
				sameCharWords.add(word);
				hashMap.put(wordKey, sameCharWords);
			}
			
		}
		result.addAll(hashMap.values());
		return result;
	}
	
	
		
	public static void main(String[] args) {
		String[] names = {"eat", "tea", "Tan", "ate", "nat", "bat"};
		System.out.println(groupAnagramsUsingSort(names));
		System.out.println(groupAnagramByArray(names));
		}

}
