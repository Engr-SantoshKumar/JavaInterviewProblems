/** 14 [find sub-anagram in a string]
 -------------------------------------------------------------------------------------------------------
 "Given 2 words, return true if second word has a substring that is also an anagram of word 1.
 ART , TARZAN - True
 ART, TREAT - False"
 */
package GooPrep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _Goo_14_TARZAN {
    static List<String> findSubAnagram(String givenString, String pattern) {

        List<String> results = new ArrayList<String>();
        int[] countDirectory = new int[26];

        // load the pattern string to countDirectory
        for(char c: pattern.toCharArray()){
            countDirectory[c -'A'] ++;
        }
        int count = pattern.length();

        for(int i =0, j =0; i < givenString.length(); i++ )
        {
            //get the current char count from countDirectory
            int charCount = countDirectory[givenString.charAt(i) -'A'];
            countDirectory[givenString.charAt(i)-'A'] --;
            if(charCount > 0) {
                count--;
            }
            /* will start looking for anagram in givenString once i [current index ] is >= patternLength */
            if(i >= pattern.length()-1){
                //Positive Cases: if we found the all char of pattern
                if(count == 0){
                    results.add(givenString.substring(j, i+1));
                }
                charCount = countDirectory[givenString.charAt(j)-'A'];
                countDirectory[givenString.charAt(j) - 'A']++;
                // will increase the charCount if the leftmost char is from pattern
                if(charCount >=0) {
                    count++;
                }
                j++;
            }
        }
        System.out.println("All sub anagrams starts from index  :  " + Arrays.toString(results.toArray()));
        return results;
   }
    public static void main(String args[]) {
        String s = "TAAZATARRTARZAN";
        String p = "ART";
        findSubAnagram(s,p);
    }
}
