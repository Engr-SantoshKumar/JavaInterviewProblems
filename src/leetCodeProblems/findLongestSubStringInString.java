package leetCodeProblems;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 
 */

/**
 * @author u494321
 *
 */
public class findLongestSubStringInString {
	public static void main (String[] args){
		
		
		uniqueLongestSubString("ababcabdfac");
		//maxConsecutiveOne("110101010111101011111");
		
	}
	
	public static String uniqueLongestSubString (String s){
		
		HashSet<Character> uniqueSet = new HashSet <Character>();
		int max =0;
		int start =0;
		int i=0;
		
		for(i =0; i<s.length(); i++){
			char c =s.charAt(i);
			if(!uniqueSet.contains(c)){
				uniqueSet.add(c);
			}
			
			else{
					max = Math.max(max, uniqueSet.size());
			
					while(start<i && s.charAt(start)!=c){
						uniqueSet.remove(s.charAt(start));
						start ++;
					}
					start ++;
					}
			}
		max = Math.max(max, uniqueSet.size());
		String longestSubString = s.substring(start, i);
		System.out.println("Longest SubString : " + longestSubString );
		System.out.println("Final max"+ max);
		return null;
	}
	

	public static  int maxConsecutiveOne (String s){
		
		int CurrentCounter = 0;
		int maxCoutof1 = 0;
		
		for(char c : s.toCharArray()){
			if (Character.getNumericValue(c)==1){
				CurrentCounter ++;
				maxCoutof1 = Math.max(maxCoutof1, CurrentCounter);
			}
			else{
				CurrentCounter =0;
			}
		}
		System.out.println("Total max consuctive counts of 1 : " + maxCoutof1);
		return maxCoutof1;
	}

}
