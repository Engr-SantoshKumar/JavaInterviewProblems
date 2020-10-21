/**
 * [ Apple_02 ] [ Reorganize String ]
 * ____________________________________________________________________________________________________________________
 Given a string S, check if the letters can be rearranged so that two characters that
 are adjacent to each other are not the same. If possible, output any possible result.
 If not possible, return the empty string.

 Input: S = "aab"
 Output: "aba"

 Input: S = "aaab"
 Output: "

 LOGIC: Poll top from PQ, check if we can append it to string or not. If not, poll one more now and append it to string
 not put back both into pq if still has count more than 0
 */
package Apple_FB_Prep;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _oA_02_Reorganize_String {

    private static String reorganizeString(String s){

        //Character Frequency count
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            int count = map.getOrDefault(c, 0)+1;
            // if the count of any char is more than half of string, then its not possible to make string
            if (count > (s.length() + 1) / 2) return "";
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
                if(--secondPoll[1] > 0)
                    maxPQ.offer(secondPoll);

                maxPQ.offer(firstPoll);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "aaaabbc";
        System.out.println("Given String : "+ s +"  Reorganize String :"+ reorganizeString(s));

    }
}
