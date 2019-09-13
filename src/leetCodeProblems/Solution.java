package leetCodeProblems;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {    
	
	static int[] minimalOperations(String[] words) {
		
		
		for(String s : words) 
		System.out.println(s);
		 
		ArrayList<Integer> list = new ArrayList<Integer>(words.length);
		 
		 for (int i =0; i<words.length; i++ ) {
			 int minimumReplacement=0;
			 String currentWord = words[i];
			 
			 for(int x =1; x<currentWord.length();x++) {
				 if(currentWord.charAt(x)==currentWord.charAt(x-1)) {
			         minimumReplacement++;
			          x = x + 1;
			         }
			}
			 if(minimumReplacement>0) {
				 list.add(minimumReplacement);

			 }else {
				 list.add(0);
				 
			 }
			
			 
		 }
		 int[] ret = new int[list.size()];
		 for (int i=0; i < ret.length; i++)
		    {
		        ret[i] = list.get(i).intValue();
		    }
		return ret;

	    }

	
	public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    final String fileName = System.getenv("OUTPUT_PATH");
    BufferedWriter bw = null;
    if (fileName != null) {
        bw = new BufferedWriter(new FileWriter(fileName));
    }
    else {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    int[] res;
    int words_size = 0;
    words_size = Integer.parseInt(in.nextLine().trim());

    String[] words = new String[words_size];
    for(int i = 0; i < words_size; i++) {
        String words_item;
        try {
            words_item = in.nextLine();
        } catch (Exception e) {
            words_item = null;
        }
        words[i] = words_item;
    }

    res = minimalOperations(words);
    for(int res_i = 0; res_i < res.length; res_i++) {
        bw.write(String.valueOf(res[res_i]));
        bw.newLine();
    }

    bw.close();
}
}