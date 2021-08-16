package GooPrep;/* [ Goo_27_00 ] [  Minimum Window Substring ]
_______________________________________________________________________________
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that
every character in t (including duplicates) is included in the window.
If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.
A substring is a contiguous sequence of characters within the string.

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
*/

import java.util.HashMap;
import java.util.Map;

public class _Goo_27_00_Minimum_Window_Substring_MAP {

    public static String minimumWindowSubstring(String str, String pat){
        String result = "";
        //base condition check
        if(str.length() < pat.length()) return result;

        //create a hashmap to save the Characters of the target(pattern) substring.
        //(K, V) = (Character, Frequency of the Characters)
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: pat.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        // a counter for size of sliding window
        // don't worry about duplicates, we will reduce counter only if the current char frequency is 0;
        int counter = map.size();
        int begin = 0, end = 0; int minLength = Integer.MAX_VALUE;

        while(end < str.length()){
            char ch = str.charAt(end++);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch)==0) counter--; // update only if count is 0, which will take care of dups
            }

            // Now we have a window which contains all the characters of pattern or maybe some extra
            // keep moving if its not part of map, if part check its count
            while(counter ==0){
                char tempCh = str.charAt(begin);
                if(map.containsKey(tempCh)){
                    map.put(tempCh, map.get(tempCh)+1);
                    //Note: only increase counter if current freq is more than 0, means avoiding incrementing count for
                    //extra char, e.g suppose we need just one a but there are 2 a between begin and end
                    if(map.get(tempCh) > 0) counter ++;
                }
                // now we have shrink the string enough ....take the current length
                //NOTE: this part is only different from problem _Goo_14_00_
                if(end-begin+1 < minLength){
                    minLength = end - begin;
                    result= str.substring(begin, begin+minLength);
                    System.out.println(result);
                }
                begin++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minimumWindowSubstring(s,t));
    }
}
