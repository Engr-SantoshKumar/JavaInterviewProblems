package leetCodeProblems;
import java.util.HashMap;

/**
 * 
 */

/**
 * @author U494321
 *
 */
public class findStringAreAnagrams {

	/**
	 * Purpose: 
	 * 
	 * U494321
	 * Jul 3, 2017
	 */

	public static void main(String[] args) {
		
		//AnagramsUsinArray("santoshkumar","kumarsantosh");
		//areAnagrams("fdsasahgfd","fdsasahgfd");
		AnagramsUsinIntArray("aa", "ab");

	}
	
	
			public static boolean AnagramsUsinArray(String s, String t) {
				System.out.println("Finding, if given String is an Anagrams or not using ARRAY");	
				if (s.length() != t.length()) {
					System.out.println("Both Strings are not egual, i.e. not an Anagrams");
					return false;
					}
				
			
				int[] letters = new int[128];
			
				char[] s_array = s.toCharArray();
			
				for (char c : s_array) { 
					letters[c]++;
				}
			
			
				for (int i= 0; i < t.length(); i++) {
					int ch = (int) t.charAt(i);
					letters[ch]--;
			
					if (letters[ch] < 0) {
						System.out.println("not an Anagrams");
						return false;
					}
				}
				System.out.println("Anagrams");
				return true;
				}

			
			
			public static boolean areAnagrams(String StringOne, String StringTwo) {
				System.out.println("Finding, if given String is an Anagrams or not using MAP");
				if (StringOne.length() == StringTwo.length()) {
			        
			        HashMap<Character, Integer> hmapString = new HashMap<Character, Integer>(StringOne.length());
			        Integer count;
			        
			        for (char c : StringOne.toCharArray()) {
			            
			        	count = hmapString.get(c); //get the count for existing char in map
		           
			            hmapString.put(c, count !=null ? count +1 : 1); //add 1 if exist else 1 for new one 
			            
			        }
			        
			        for (char c : StringTwo.toCharArray()) {
			            count = hmapString.get(c);//get the total count for char
			            if (count == null) {
			            	System.out.println("not a Anagrams");
			                return false;
			            } else {
			                count--; // subtract 1 and load in map
			                hmapString.put(c, count);
			            }
			        }
			        for (Integer i : hmapString.values()) {
			            if (i != 0) {
			            	System.out.println("not a Anagrams");
			                return false;
			            }
			        }
			        System.out.println("Anagrams");
			        return true;
			    } 
			   else {
			       System.out.println("Both Strings are not egual, i.e. not an Anagrams"); 
				   return false;
			    }
			}
			
			
			public static boolean AnagramsUsinIntArray(String s, String t) {
				System.out.println("Finding, if given String is an Anagrams by using Int ARRAY");	
				if (s.length() != t.length()) {
					System.out.println("Both Strings are not egual, i.e. not an Anagrams");
					return false;
					}
				
			
				int[] letters = new int[128];
			
				for (char c : s.toCharArray()) { 
					letters[c]++;
				}
			
			
				for (char ch:t.toCharArray()) {
					
					letters[ch]--;
			
					if (letters[ch] < 0) {
						System.out.println("not an Anagrams");
						return false;
					}
				}
				System.out.println("Anagrams");
				return true;
				}
}
