/* [ _SlidingWindow_04_ ] [ String Anagrams ]
_______________________________________________________________________________
Given a string and a pattern, find all anagrams of the pattern in the given string.
Anagram is actually a Permutation of a string.
String="ppqp", Pattern="pq"
Output: [1, 2]--> The two anagrams of the pattern in the given string are "pq" and "qp".

Logic:
Similar to Permutation in a  String. In this problem, we need to find every occurrence of any
permutation of the pattern in the string. We will use a list to store the starting indices of
the anagrams of the pattern in the string.
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class _SlidingWindow_04_Find_All_Anagrams_in_Given_String {
    public static List<Integer> findStringAnagrams(String str, String pattern){
        int windowStart=0;
        int matched =0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        //load pattern to charFrequencyMap
        for(char ch:pattern.toCharArray()){
            charFrequencyMap.put(ch,charFrequencyMap.getOrDefault(ch,0)+1);
        }
        List<Integer> resultIndices = new ArrayList<>();

        //Our goal is to match all the char from the map with current window
        for(int endWindow =0; endWindow < str.length(); endWindow++){
            char rightChar = str.charAt(endWindow);

            //decrement the frequency of the matched character
            if(charFrequencyMap.containsKey(rightChar)){
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar)-1);
                if (charFrequencyMap.get(rightChar) == 0)
                    matched++;
            }

            //have we found the anagram?
            if(matched==charFrequencyMap.size()){
                resultIndices.add(windowStart);
            }

            //shrink the window.. if the anagram found or not we need to trim the left char as size is >= pattern len
            if(endWindow >=pattern.length() -1 ){
                char leftChar = str.charAt(windowStart);
                if(charFrequencyMap.containsKey(leftChar)){
                    if (charFrequencyMap.get(leftChar) == 0){
                        matched--;
                    }
                    //update the windowStartPointer and count of leftChar +1 as its out of sliding window
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar)+1);
                }
                windowStart++;
            }
        }
        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(findStringAnagrams("ppqp", "pq"));
        System.out.println(findStringAnagrams("abbcabc", "abc"));
        System.out.println(findStringAnagrams("abbcacbc", "ac"));
    }
}
