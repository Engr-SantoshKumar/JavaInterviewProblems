/* [ _Heaps_03 ] [ Reorganize String ]
_______________________________________________________________________________
Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.
Input: s = "aab"
Output: "aba"
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _Heaps_03_Reorganize_string {

    private static String reorganizeString(String s){
    //Character Frequency count
    Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
        int count = map.getOrDefault(c, 0)+1;
        // if the count of any char is more than half of string, then its not possible to make string
        if (count > (s.length() + 1) / 2) return "not Possible";
        map.put(c, count);
    }

    // Use PriorityQueue to store pairs of (char, count) and sort by count DESC.
    PriorityQueue<int[]> maxPQ = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char c : map.keySet()) {
        maxPQ.add(new int[] {c, map.get(c)});
    }

    // Build the result.
    StringBuilder result = new StringBuilder();

    // now lets construct the string
        while (!maxPQ.isEmpty()){
            int[] firstPoll = maxPQ.poll();
            //check if we can add char from firstPoll or not
            if(result.length() == 0 || result.charAt(result.length()-1) != firstPoll[0]){
                result.append((char) firstPoll[0]);
                // reduce the count and put it back
                if(--firstPoll[1] > 0)
                    maxPQ.offer(firstPoll);
            }else{
                int[] secondPoll = maxPQ.poll();
                result.append((char) secondPoll[0]);
                // put back both firstPoll and secondPoll
                if(--secondPoll[1] > 0){
                    maxPQ.offer(secondPoll);
                }
                maxPQ.offer(firstPoll);
            }
        }
        return result.toString();
}

    public static void main(String[] args) {
        System.out.println("Given String : "+ "aaaabbc" +"  Reorganize String :"+ reorganizeString("aaaabbc"));
        System.out.println("Given String : "+ "aaaaabbc" +"  Reorganize String :"+ reorganizeString("aaaaabbc"));
        System.out.println("Given String : "+ "aab" +"  Reorganize String :"+ reorganizeString("aab"));
        System.out.println("Given String : "+ "abc" +"  Reorganize String :"+ reorganizeString("abc"));
    }
}
