/** 47-02 [Sliding Window Longest Substring Which Contains K Unique Characters]
 -----------------------------------------------------------------------------------------------------------------
 Given a string, find the longest substring that contains only [K = two] unique characters.
 For example, given "abcbbbbcccbdddadacb",
 the longest substring that contains 2 unique character is "bcbbbbcccb".


 */
package PrepSetOne;
import java.util.HashMap;
import java.util.Map;

public class _Goo_47_02_Longest_Substring_With_K_Chars_Map {

    public static int lengthOfLongestSubstringKDistinct(String givenString, int k) {

        Map<Character, Integer> map = new HashMap<>();
        int start=0; int end=0; int len =0; int count=0;
        // Used the same template of _Goo_14_00_Find_All_Anagrams_in_String_UsingMAP
        while (end < givenString.length()){
            char ch = givenString.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            if(map.get(ch)==1) count++;
            end++;

            while ( count > k){
                char tempCh = givenString.charAt(start);
                map.put(tempCh, map.get(tempCh)-1);
                if(map.get(tempCh)==0) count--;
                start++;
            }
            System.out.println(givenString.substring(start, end));
            len = Math.max(len, end-start);
        }
        return len;

    }
    public static void main(String[] args) {
        String s = "aaccbbdbcccbdddadacb";
        String s1 = "abc";
        System.out.println("\n\nlongest substring ");
        System.out.println(lengthOfLongestSubstringKDistinct(s, 2));
    }
}

