package leetCodeProblems;
import java.awt.List;
import java.util.ArrayList;

// this solution has quadratic time complexity i.e. O(n^2) and space complexity O(n)

public class findingDuplicatesUsingArray {

	public static void main(String[] args) {
		
		int[] numbers = {1,0,3,4,2,1,2,4,0,6,7,8,9};
		charDublicated("harikrishna");
		intDublicates(numbers);
        
    }
	
	public static String charDublicated(String s){
        String s2 = "";
        for (int i = 0; i < s.length(); i++) {
            
        	Boolean found = false;
            
            for (int j = 0; j < s2.length(); j++) 
            {
                	if (s.charAt(i) == s2.charAt(j)) 
                	{
                		found = true;
                		break; //don't need to iterate further
                	}
            }
           
            if (found == false) {
                s2 = s2.concat(String.valueOf(s.charAt(i)));
            }
        }
        
        System.out.println("There are the Duplicates Char : "+s2);
		return s2;
		
	}
	
	public static Integer intDublicates( int[] nums){
		
		int[] count = new int[258];
		ArrayList<Integer> dupInt = new ArrayList<Integer>();
		
		for (int i : nums){
			count[i]++;
		}
		
		for (int c : nums){
			
			if (count[c]>1){
				dupInt.add(c);
				count[c]=0;
			}
		}
		
		System.out.println(dupInt);
		return null;
		
	}
	
	public static boolean permutation(String s, String t) {
		if (s.length() != t.length()) {
		return false;
		}
	
		int[] letters = new int[128];

			char[] s_array = s.toCharArray();
			for (char c : s_array) { 
				letters[c]++;
				}


			for (int i= 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			letters[c]--;
			if (letters[c] < 0) {
				return false;
				}
			}
		return true;
	
	}
}

