/** [Goo_30_A]  [Top Frequent Words in Document]
 ---------------------------------------------------------------------------------------------------------
 Steps:
 1. Create a string array to load all the words from stream
 2. load in a hashMap (word, counts)
 3. Create a priority Queue with initial size 'K' and a in-build with comparator, comparing their counts
 4. Iterate over hashMap and load pq for initial size and then compare with the top element is pq, if its smaller than new,
 replace with the new one
 5. keep popping pq until it become empty to get the top 'K' frequently occurred elements
 */

package GooPrep;

import java.util.*;

public class _Goo_30_A_Top_Frequent_Words_in_Document {

    public static List<String> topKWords(List<String> list, int k) {
        Map<String, Integer> hMap = new HashMap<>();
        for (String s : list) {
            hMap.put(s, hMap.getOrDefault(s,0)+1);
        }
        System.out.println(hMap);
        // Default capacity for priority queue is 11
        PriorityQueue<WordCount> pq = new PriorityQueue<WordCount>((a,b) -> a.count - b.count);

        for (Map.Entry<String, Integer> mapEntry : hMap.entrySet()) {
            if (k>0) {
                pq.offer(new WordCount(mapEntry.getKey(), mapEntry.getValue()));
                k--;
            }
            else {
                WordCount newWord = new WordCount(mapEntry.getKey(), mapEntry.getValue());
                if (pq.peek().count < newWord.count) {
                    pq.poll();
                    pq.offer(newWord);
                }
            }
        }
        while (!pq.isEmpty()) {
            WordCount wc = pq.poll();
            System.out.println(String.format("%s : %s", wc.word, wc.count));
        }
        return null;
    }
    public static void main(String[] args) {
        String[] s = {"hi", "hello", "hi", "hello", "hi", "hello", "hi", "hello", "hi", "sk", "sk", "dk", "pk"};
        topKWords(Arrays.asList(s), 2);
    }
}


class WordCount {
    String word;
    int count;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }
}

