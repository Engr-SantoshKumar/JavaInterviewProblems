/** 10 [Top K Numbers]
---------------------------------------------------------------------------------------------------
 * how would you find top 10 largest number in a very large data set
 * steps:
 *  1. Create pq of initial given K size
 *  2. fill the pq for K size
 *  3. compare the incoming element with the 1st element of pq
 */
package GooPrep;
import java.util.PriorityQueue;

public class _Goo_10_FindTopKthLargest {

    static void topK(int[] ar, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int a : ar) {
            if (pq.size() < k) {
                pq.offer(a);
            } else {
                int j = pq.peek();
                if(a > j){
                    pq.poll();
                    pq.offer(a);
                }
            }
        }
        while (!pq.isEmpty()) {
                    System.out.println(pq.poll());
        }
    }

    public static void main(String[] args) {
        int[] ar = new int[]{1, 6, 7, 8, 9, 2, 3, 4, 5};
        int k = 3;
        topK(ar, k);
    }
}
