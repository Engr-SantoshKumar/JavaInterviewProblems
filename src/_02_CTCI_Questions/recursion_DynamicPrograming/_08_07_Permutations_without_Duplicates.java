/* recursion return for abc :     "" --> c+"" (i.e.  c ) --> bc & cb ---> abc, bac, bca & acb, cab, cba    
 * 
 * 
 */

package _02_CTCI_Questions.recursion_DynamicPrograming;

import java.util.ArrayList;

public class _08_07_Permutations_without_Duplicates {
	
	
	static ArrayList<String> getPermutaion(String s){
		if(s == null) return null;
		
		ArrayList<String> permutations = new ArrayList<String>();
		
		if(s.length() == 0){ // base condition, from here the recursion will return with "" 
			permutations.add("");
			return permutations;
		}
		
		char firstChar = s.charAt(0);
		String remaining = s.substring(1);
		ArrayList<String> WORDS = getPermutaion(remaining); // calling recursion untill it get to base condition 
		
		// check all the word(strings) in WORDS array 
		for(String word : WORDS){
			//now inserting 1st char next to each chars of words 
			for(int i =0; i<= word.length(); i++){
				String k = createWord(firstChar, word, i );
				permutations.add(k);
			}
		}
		return permutations;
	}
		
		static String createWord(char firstChar, String word, int i){
			String beforeChar = word.substring(0,i);
			String afterChar = word.substring(i);
			return beforeChar+ firstChar+ afterChar;
			
		}

	public static void main(String[] args) {
		ArrayList<String> list = getPermutaion("abcdf");
		System.out.println("There are " + list.size() + " permutations.");
		for (String s : list) {
			System.out.println(s);
		

	}

}
}	
