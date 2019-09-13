/* 1.1 Find if the String has all unique characters w/o any additional data structure
 * Soln: 1. Create array of 128 
 * 		 2. Update array index against string char 
 * 		 3. while loading check if the index value more than zero, if yes duplicate  
 */

package _02_CTCI_Questions.arrayAndString;

public class findStringHasAllUniqueChar {

	public static void main(String[] args) {
		System.out.println(findStringHasAllUniqueChar.IsAllUnique("abcdefa"));
		System.out.println(findStringHasAllUniqueChar.IsAllUnique("abcdef"));
		
	}

	public static Boolean IsAllUnique (String s1){
		
		int [] charCount = new int[128];
		
		for(char ch : s1.toCharArray()){
			if(charCount[ch]>0){
				return false;
			}else
				charCount[ch]++;
		}		
		return true;
		
	}
}