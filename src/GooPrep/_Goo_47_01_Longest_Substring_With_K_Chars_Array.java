/* 47-01 [Longest Substring Which Contains K Unique Characters]
 -----------------------------------------------------------------------------------------------------------------
 Given a string, find the longest substring that contains only [K = two] unique characters.
 For example, given "abcbbbbcccbdddadacb",
 the longest substring that contains 2 unique character is "bcbbbbcccb".
 NOTE: Logic is same as _Goo_14_TARZAN and _Goo_27_Min_Window_Substring
 Ony Difference is we load countDirectory array inside for loop
  */
package GooPrep;
import java.util.HashSet;
import java.util.Set;

public class _Goo_47_01_Longest_Substring_With_K_Chars_Array {

    public static String longestSubstr(String givenString, int K){

        if(givenString.length() ==0) return null;
        int[] countDirectory = new int[128];
        String longestString = "";
        Set<Character> hSet = new HashSet<>();
        // [start....current] maintain sliding window boundaries
        for(int start =0, end =0; end<givenString.length(); end++)
        {
            char ch = givenString.charAt(end);
            hSet.add(ch);
            countDirectory[ch]++;

            if(hSet.size()>=K){
                if(hSet.size() == K){
                    String curString = givenString.substring(start, end +1);
                    if(curString.length() > longestString.length() )
                        longestString = curString;
                }
                //update charCount and hSet for 'start Index' if V:1 remove from map, else V:--;
                while(hSet.size() > K)
                {
                    if(countDirectory[givenString.charAt(start)] ==1)
                        hSet.remove(givenString.charAt(start));
                    countDirectory[givenString.charAt(start)]--;
                    start++;
                }
            }
        }
        return longestString;
    }

    public static void main(String[] args) {
        String s = "bccbabab"; // "ccbbbbcccbdddadacb";
        System.out.println("\n\nlongest substring ");
        System.out.println(longestSubstr(s, 2));
    }
}