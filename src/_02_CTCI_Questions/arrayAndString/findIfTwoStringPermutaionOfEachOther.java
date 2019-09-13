/* 1.2 Find if the two given string s1 and s2 are permutation i.e if the are Anagrams
 * soln: 1. check both length
 * 		 2. Create array of 128 
 * 		 2. Update array index against s1 string char's count
 * 		 3. Check loaded array against s2 char, check if index value is 0 --> return false else decrease index value 
 * 
 */
package _02_CTCI_Questions.arrayAndString;

public class findIfTwoStringPermutaionOfEachOther {

	public static void main(String[] args) {
		
		String s1 = "abcd";
		String s2 = "dabc";
		
		System.out.println(findIfTwoStringPermutaionOfEachOther.IsPermutaion(s1, s2));

	}
	
	public static Boolean IsPermutaion (String s1, String s2){
		if(s1.length()!=s2.length()){
			return false;
		}
		int [] charCountArray = new int [128];
		
		for(char ch: s1.toCharArray()){
			charCountArray[ch]++;
		}
		
		for(char ch:s2.toCharArray()){
			if(charCountArray[ch]==0){
				return false;
			}else
				charCountArray[ch]--;
		}
		
		return true;
		
	}

}
