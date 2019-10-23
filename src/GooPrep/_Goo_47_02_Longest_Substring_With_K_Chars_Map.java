/** 47-02 [Longest Substring Which Contains K Unique Characters]
 -----------------------------------------------------------------------------------------------------------------
 Given a string, find the longest substring that contains only [K = two] unique characters.
 For example, given "abcbbbbcccbdddadacb",
 the longest substring that contains 2 unique character is "bcbbbbcccb".
 */
package GooPrep;
import java.util.HashMap;

public class _Goo_47_02_Longest_Substring_With_K_Chars_Map {

    public static String lengthOfLongestSubstringKDistinct(String givenString, int k) {

        String longestString = "";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        // [start....current] maintain sliding window boundaries
        for(int start =0, current=0; current<givenString.length(); current++)
        {
            char c = givenString.charAt(current);
            map.put(c, map.getOrDefault(c, 0) +1);

            // if window size is more than k, remove characters from the left
            if(map.size()>=k){
                if(map.size()==k){
                    String curString = givenString.substring(start, current +1);
                    // update maximum window size if necessary
                    if(curString.length() > longestString.length() )
                        longestString = curString;
                }
                while(map.size()>k)
                {
                    //update map for 'start Index' if V:1 remove from map, else V:--;
                    char l = givenString.charAt(start);
                    int count = map.get(l);
                    if(count==1) {
                        map.remove(l);
                    }
                    else {
                        map.put(l, map.get(l)-1);
                    }

                    start++; // reduce window size
                }
            }
        }
        return longestString;
    }
    public static void main(String[] args) {
        String s = "aaccbbbbcccbdddadacb";
        String s1 = "abc";
        System.out.println("\n\nlongest substring ");
        System.out.println(lengthOfLongestSubstringKDistinct(s, 2));
    }
}
