/** 30  [Top Frequent Words in Document]
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
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _Goo_30_Top_Frequent_Words_in_Document {

    public static void findTopFrequentWords(String str, int topWordsNo){
        //base cases
        if(str.length() == 0) return;

        //when only one only one word
        if(str.length() ==1){
            System.out.println("Word : " + str + "Frequency : " + str.length());
            return;
        }
        Map<String, Integer> hMap = new HashMap<>();
        String[] words = str.split(" ");

        for(String word : words){
            hMap.put(word, hMap.getOrDefault(word,0)+1);
        }
        System.out.println(hMap);
        // create a pq of size (count of top words) with comparator, comparing their counts

        PriorityQueue<WordAndCount> pq = new PriorityQueue<>((a,b)->(a.count - b.count));

        for(Map.Entry<String, Integer> entry : hMap.entrySet()){
            if(topWordsNo > 0){
                pq.offer(new WordAndCount(entry.getKey(), entry.getValue()));
                topWordsNo --;
            }
            else
            {
             WordAndCount top = pq.peek();
             if(top.count < entry.getValue()){
                 pq.poll();
                 pq.offer(new WordAndCount(entry.getKey(), entry.getValue()));
             }
            }
        }
        while(!pq.isEmpty()){
            WordAndCount wc = pq.poll();
            System.out.println("Word : "+ wc.word + " its Frequency : " +wc.count);
        }
    }
    public static void main(String[] args) {
        String stream = "l l l l a b e f d t c r x z l i i i i i i i i j j j k k k k m m n a b e f d t c r x z";
        //String stream = "l";
        int topCount = 3;
        findTopFrequentWords(stream, topCount);
    }

    static class WordAndCount{
        String word;
        int count;

        public WordAndCount(String word, int count){
            this.word=word;
            this.count=count;
        }
    }
}


