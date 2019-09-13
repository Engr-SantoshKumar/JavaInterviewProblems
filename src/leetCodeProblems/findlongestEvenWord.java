package leetCodeProblems;

import java.io.*;

class findlongestEvenWord {
 
	public static void main(String[] args) throws IOException {
        int maxLength = 0;
        String longestWorld = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter p = new PrintWriter(System.out, true);
        p.println("Enter string");
        String str = br.readLine();
       
        int startIndexOfWord = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                String word = str.substring(startIndexOfWord, i);
                if (word.length() > maxLength & word.length()%2==0  ) {
                    maxLength = word.length();
                    longestWorld=word;
                }
                startIndexOfWord = i + 1;
            }
        } 
        
        //now check the last word 
        String word = str.substring(startIndexOfWord, str.length());
        if (word.length() > maxLength& word.length()%2==0 ) {
            maxLength = word.length();
            longestWorld=word;
        }
        System.out.println(longestWorld);
        //return longestWorld;
    }
}