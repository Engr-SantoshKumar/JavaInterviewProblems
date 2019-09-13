/* There are three types of edits that can be performed on strings: insert a character,
 *   remove a character, or replace a character. Given two strings, write a function to check if they are
 *   one edit (or zero edits) away.
 * Soln: 1. Create two method one to handle if there is replacement (i.e. s1.length == s2.length) another method for (s1<s2 || s2<s1)
 *       2. In case of (s1<s2 || s2<s1) call the method by swiping the string 
 * 		 3. Compare the string with 
 */

package _02_CTCI_Questions.arrayAndString;

public class oneWayString {

	public static void main(String[] args) {
		String s1= "aple";
		String s2= "apple";
		

		if (s1.length() == s2.length()) {
			 System.out.println(oneAwayReplacement(s1, s2));
		} else if (s1.length() + 1 == s2.length()) {
			 System.out.println(oneAwayInsertOrDeleate(s2, s1));
		} else if (s1.length() - 1 == s2.length()) {
			 System.out.println(oneAwayInsertOrDeleate(s1, s2));
		} else{
			System.out.println(s1 + ", " + s2 + ": " + "false");
		}
		

	}
	
	
	public static boolean oneAwayReplacement(String l, String s){
		int diffChar =0;
		for (int i =0; i< l.length();i++){
			if(l.charAt(i)!=s.charAt(i)){
				diffChar ++;
				if(diffChar>1){
					return false;
				}
			}
		}
		return true;		
	}
	
	public static boolean oneAwayInsertOrDeleate(String l, String s){

		
		int index1 = 0;
		int index2 = 0;
		
		while(index1<l.length() && index2 < s.length()){

			if(l.charAt(index1) != s.charAt(index2)){
				if(index1 != index2){
					return false;
				}
				index1++;
			}else{
				index1 ++;
				index2 ++;
			}
		}
		return true;
		
	}

}
