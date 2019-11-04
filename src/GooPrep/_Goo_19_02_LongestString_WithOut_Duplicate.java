/**
[19-02 ] [Longest Substring Without Repeating Characters ]
-----------------------------------------------------------------------------------------------------
 Input: "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.
 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
package GooPrep;

import java.util.HashSet;
import java.util.Set;

public class _Goo_19_02_LongestString_WithOut_Duplicate {

    public static int longestSubStringWithDups(String str){

        if(str== null) return 0;
        int count =0;
        int i=0, j =0;
        Set<Character> hSet = new HashSet<>();
        while(i<str.length())
        {
            if(!hSet.contains(str.charAt(i))){
                hSet.add(str.charAt(i++));
                //System.out.println(str.substring(j,i));
            }else{
                count = Math.max(count, hSet.size());
                hSet.remove(str.charAt(j++));
            }
        }
        count = Math.max(count, hSet.size());
        return count;
    }

    public static void main(String[] args) {
        String s = "abcdef";
        System.out.println(longestSubStringWithDups(s));
    }
}
