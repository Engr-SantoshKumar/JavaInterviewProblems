/*
 [19-02 ] [Sliding Window Longest Substring Without Repeating Characters using MAP ]
 -----------------------------------------------------------------------------------------------------
 Input: "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.
 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 Other approach using set is : _Goo_19_02_LongestString_WithOut_Duplicate
 Logic using map: hashmap which stores the characters in string as keys and their positions as values,
 and keep two pointers which define the max substring
 */
package Code_Run_Build_LC350;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _oA_22_LongestSubstringWithoutRepeatingCharacters {

    public static int longestSubStringWithRepeatingChar(String str){
        //base cases
        if(str == null || str.length() == 0) return 0;

        // map to store K->char and V->charLastVisitedPosition
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int maxLen =0;

        for(int i=0, j =0; i<str.length(); i++){
            //check if map contains current get the size
            if(hashMap.containsKey(str.charAt(i))){
                j = hashMap.get(str.charAt(i)) + 1; // now we have position of previous occurrence of current char
            }
            //current substring length with repeating char will be i-j
            maxLen = Math.max(maxLen, i-j+1);
            //put the current char with position
            hashMap.put(str.charAt(i), i);
        }
    return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcdaa";
        System.out.println(longestSubStringWithRepeatingChar(s));
    }
}
