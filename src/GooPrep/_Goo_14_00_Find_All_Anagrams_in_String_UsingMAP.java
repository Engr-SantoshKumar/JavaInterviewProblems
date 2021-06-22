package GooPrep;/* [  ] [ Find All Anagrams in a String [TARZEN] ]
_______________________________________________________________________________
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 "Given 2 words, return true if second word has a substring that is also an anagram of word 1.
 ART , TARZAN - True
 ART, TREAT - False"

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _Goo_14_00_Find_All_Anagrams_in_String_UsingMAP {

    public static List<Integer> findAnagrams(String str, String pat){
        //init a collection or int value to save the result according the question.
        List<Integer> result = new LinkedList<>();
        if(pat.length()> str.length()) return result;

        //create a hashmap to save the Characters of the target(pattern) substring.
        //(K, V) = (Character, Frequency of the Characters)
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: pat.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        // a counter for size of sliding window
        // dont worry about duplicates, we will reduce counter only if the current char frequency is 0;
        int counter = map.size();

        int begin = 0, end = 0;

        while(end < str.length()){
            char c = str.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;

            // now we have a window which contains all the chars of pattern
            while(counter == 0){
                // need trimming from starts
                char tempCh = str.charAt(begin);
                if(map.containsKey(tempCh)){
                    map.put(tempCh, map.get(tempCh) + 1);
                    // we will only increase the counter if count is more than 0,
                    // means if its less than 0 those are just extra characters e.g. a=2 we need 2 a,
                    // but we have 3 a between begin and end
                    if(map.get(tempCh) > 0){
                        counter++;
                    }
                }
                // check if current window size equals pattern size
                //NOTE: this is only part different then in problem MinWindowSubstring _Goo_27_00
                if(end-begin == pat.length()){
                    result.add(begin);
                    System.out.println(str.substring(begin,(begin+pat.length())));
                }
                begin++;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        String s = "TAZATARRTARZAN";
        String p = "ART";
        String s1 = "CBAACCBBCAA";
        String p1 = "AABC";
        String s2 = "CBAACACBBCAA";
        String p2 = "AABC";
        System.out.println(findAnagrams(s,p));
    }
}
