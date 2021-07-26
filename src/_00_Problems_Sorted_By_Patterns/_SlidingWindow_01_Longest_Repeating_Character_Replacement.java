/* [ _SlidingWindow_01_ ] [ Longest Repeating Character Replacement ]
_______________________________________________________________________________
Given a string s and an integer k. You can choose any character of the string and change it to any other character.
You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

Input: s = "ABAB", k = 2
Output: 4 -
Explanation: Replace the two 'A's with two 'B's or vice versa.

Input: s = "AABABBA", k = 1
Output: 4 --> Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.

Logic:
We’ll iterate through the string to add one letter at a time in the window.
We’ll also keep track of the count of the maximum repeating letter in any window (let’s call it maxRepeatLetterCount).
So at any time, we know that we can have a window which has one letter repeating maxRepeatLetterCount times,
this means we should try to replace the remaining letters. If we have more than ‘k’ remaining letters,
we should shrink the window as we are not allowed to replace more than ‘k’ letters.

=> SizeOfSubString = maxRepeatLetterCount + k, so we create a sliding window of
=> so, SizeOfSubString-maxRepeatLetterCount > K  ---> we to do something..what remove fromEndAnd Shrink window
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.HashMap;
import java.util.Map;

public class _SlidingWindow_01_Longest_Repeating_Character_Replacement {
    public static int longestSubStringWithKReplacement(String str, int k){
        int windowStart=0;
        int maxLength=0;
        int maxRepeatingCharCount=0;

        Map<Character, Integer> countMap = new HashMap<>();
        //extending the range window_start, Window_end
        for(int windowEnd =0; windowEnd<str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            countMap.put(rightChar,countMap.getOrDefault(rightChar, 0 )+1);
            maxRepeatingCharCount = Math.max(maxRepeatingCharCount, countMap.get(rightChar));
            /*
            SoOoo What we have until now : Current window from windowStart to windowEnd,
            contains letter which is repeating 'maxRepeatingCharCount' times + some(remaining) chars which can be replace
            --> IF the some(remaining) characters count are more than k, its the time to shrink the window as we are not
            allowed to replace more then k characters [len-maxChCount > k]
             */
            if((windowEnd-windowStart+1 - maxRepeatingCharCount) > k ){
                //shrink
                char leftChar = str.charAt(windowStart);
                //update countMap
                countMap.put(leftChar,countMap.get(leftChar)-1);
                windowStart++;
            }
            maxLength= Math.max(maxLength, windowEnd-windowStart+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "aabccbb";
        System.out.println(longestSubStringWithKReplacement(str, 2));
        System.out.println(longestSubStringWithKReplacement("abbcb", 1));
    }

}
