package leetCodeProblems;
import java.util.Arrays;


public class findMinCharToGetNonRepeatingContinuousChart {
	
	  public static void main(String[] args) {
	    //String a[] = {"ab", "aab", "abb", "abab", "abaaabbaa", "aabbaabbaa"};
		  String a[] = {""};  
	    int[] k =minimalOperations(a);
	    System.out.println(Arrays.toString(k));
	  }

	  
	  
	  
	  static int[] minimalOperations(String[] words) {

	    for (String s : words)
	      System.out.println(s);

	    int[] a = new int[words.length];
	    for (int i = 0; i < words.length; i++) {
	      String currentWord = words[i];
	      int minimumReplacement = 0;
	      for (int x = 1; x < currentWord.length(); x++) {
	    	  System.out.println(currentWord.charAt(x)+ "==" + currentWord.charAt(x - 1));
	        if (currentWord.charAt(x) == currentWord.charAt(x - 1)) {
	          minimumReplacement++;
	          x = x + 1;
	        }
	      }
	      if (minimumReplacement > 0) {
	        a[i] = minimumReplacement;
	      } else {
	        a[i] = 0;
	      }
	    }
	    return a;
	  }
	}


