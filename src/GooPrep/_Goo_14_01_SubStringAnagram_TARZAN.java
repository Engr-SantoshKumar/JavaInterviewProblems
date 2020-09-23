/** 14 [01] [Sliding Window find sub-anagram in a string]
 -------------------------------------------------------------------------------------------------------
 "Given 2 words, return true if second word has a substring that is also an anagram of word 1.
 ART , TARZAN - True
 ART, TREAT - False"
 */
package GooPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _Goo_14_01_SubStringAnagram_TARZAN {

    static List<String> findSubAnagram(String givenString, String pattern) {

        List<String> results = new ArrayList<String>();
        int[] countDirectory = new int[256];

        // load the pattern string to countDirectory
        for(char c: pattern.toCharArray()){
            countDirectory[c] ++;
        }

        int patternLength = pattern.length();
        int requiredCount = pattern.length();

        for(int i =0 ; i < givenString.length(); i++ ){
            //get the current char count from countDirectory
            int charCount = countDirectory[givenString.charAt(i)];

            /** Reduce the count from countDirectory for current char
             Case a: if the current char is in pattern its count will be reduced by 1..
             case b: if the current char is NOT in pattern, its count will go in negative ( 0--> -1 --> -2)
             */
            countDirectory[givenString.charAt(i)] --;

            /* if the count of current char is more than 0, that means current char is in pattern
             * so, will reduce the remainingCount by 1 */
            if(charCount > 0) {
                requiredCount--;
            }
            /* will start looking for anagram in givenString once i [current index ] is >= patternLength */
            if(i >= patternLength -1){ //-1 because its index
                //Positive Cases: if we found the all char of pattern
                if(requiredCount == 0){
                    int str = i-patternLength+1;
                    int end = str+patternLength;   //or  end = i+1
                    results.add(givenString.substring(str, end));
                }
                /*If we not found the pattern, and i is already grater than pattern length..
                so there is no point of keeping the left most char..
                so we will remove the left most char and update the remainingCount accordingly
                */
                // get the charCount of the left most char, leftmost char will be at index:
                // currentIndex(i) - patternLength + 1
                charCount = countDirectory[givenString.charAt(i - patternLength + 1)];

                // will increase the charCount if the leftmost char is from pattern
                if(charCount >=0){
                    requiredCount ++;
                }
                //very imp step: we need to restore the count for removed char too
                countDirectory[givenString.charAt(i- patternLength +1 )]++;
            }
        }
        System.out.println("All sub anagrams starts from index  :  " + Arrays.toString(results.toArray()));
        return results;
    }
    public static void main(String args[]) {
        String s = "TAZATARRTARZAN";
        String p = "ART";
        findSubAnagram(s,p);
    }
}
