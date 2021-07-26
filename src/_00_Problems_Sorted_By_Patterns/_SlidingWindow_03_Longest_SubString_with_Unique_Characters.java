package _00_Problems_Sorted_By_Patterns;/* [ _SlidingWindow_03_L ] [ No-repeat Substring ]
_______________________________________________________________________________
Given a string, find the length of the longest substring which has no repeating characters.
Input: String="aabccbb"
Output: 3
Explanation: The longest substring without any repeating characters is "abc".
Logic: This problem follows the Sliding Window pattern and we can use a similar dynamic sliding window strategy
 as discussed in Longest Substring with K Distinct Characters.
 We can use a HashMap to remember the last index of each character we have processed.
 Whenever we get a repeating character we will shrink our
sliding window to ensure that we always have distinct characters in the sliding window.
*/

import java.util.HashMap;
import java.util.Map;

public class _SlidingWindow_03_Longest_SubString_with_Unique_Characters {
    //Other approach using set is : _Goo_19_02_LongestString_WithOut_Duplicate
    //this approach: we use HashMap to remember the last index of each character we have processed.
    public static int findLongestSubstring(String str){
        int windowStart =0;
        int maxLength =0;
        Map<Character, Integer > charIndexMap = new HashMap<>();

        //extend range [windowStart, windowEnd]
        for(int windowEnd =0; windowEnd<str.length(); windowEnd++){
            char rightChar= str.charAt(windowEnd);
            if(charIndexMap.containsKey(rightChar)){
                //Case 1(straight forward): if the current char is already in map, get its last index stored and
                //       move left to its last index+1(+1 as we want to remove it from subArray)
                //Case 2: if left is already ahead of the last index, we will keep left position as is
                //e.g: a b c d b a k l --> once the right is at 2nd b(index 4) we will move the left to index 4+1=5,
                // now we encounter a, last index of a -> 0, as now left is already at 5..which is ahead of 0 not need to go back
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) +1);
            }
            charIndexMap.put(rightChar,windowEnd);//insert right char to map
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "abccdef";
        System.out.println(findLongestSubstring(str));
    }
}
