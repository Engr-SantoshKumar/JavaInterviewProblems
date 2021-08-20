/* [ _Heaps_06_ ] [ Top K Frequent Words ]
_______________________________________________________________________________
Given an array of strings words and an integer k, return the k most frequent strings.
Return the answer sorted by the frequency from highest to lowest. Sort the words with the
same frequency by their lexicographical order.

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
with the number of occurrence being 4, 3, 2 and 1 respectively.

*/
package _00_Problems_Sorted_By_Patterns;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class _Heaps_06_Top_K_Frequent_Words {
    public static List<String> topKFrequent(String[] words, int k) {

        List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++)
        {
            map.put(words[i], map.getOrDefault(words[i],0)+1);
        }
        /*why b.getKey().compareTo(a.getKey()) being returned instead of a.getKey().compareTo(b.getKey())
        b.getKey().compareTo(). Since we are using min-heap and our desired result is to grab the higher frequency
        and smaller alphabet, we want to locate things in the opposite way in min-heap; lower frequency and bigger
        alphabet, so that we could remove an undesired candidate each time. Let take the first example in leetcode,
        in Heap following the condition of
        (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue(),
        we have [{i:2}, {love:2}, {coding:1}, {leetcode:1}], then we are using result.add(0, pq.poll().getKey()),
        meaning that we are poping the top(top is rightmost) and grab its key.
        So, if we continuously polling until priority queue is empty, the arraylist would be
        look like this: [leetcode] -> [coding, leetcode] -> [love, coding, leetcode] -> [i, love, coding, leetcode].
         */
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );

        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            pq.offer(entry);
            if(pq.size()>k)
                pq.poll();
        }

        while(!pq.isEmpty())
            result.add(0, pq.poll().getKey());

        return result;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"};
        System.out.println(topKFrequent(words, 3));
    }
}
