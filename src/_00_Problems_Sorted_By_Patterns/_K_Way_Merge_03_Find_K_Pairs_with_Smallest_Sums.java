/* [ _K_Way_Merge_03_ ] [ 373. Find K Pairs with Smallest Sums ]
_______________________________________________________________________________
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.*;

public class _K_Way_Merge_03_Find_K_Pairs_with_Smallest_Sums {
    public static List<int[]> kSmallestPairs(int[] array1, int[] array2, int k) {
        List<int[]> result = new ArrayList<>();
        //base boundaries check
        if(array1==null || array2==null || array1.length==0 || array2.length==0)
            return result;

        //Logic is to use PQ put all combination and pick top K
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> ((a[0]+a[1]) - (b[0]+b[1]))); //sorted by pair sum

        // offer initial pairs {array1, array2, index_of_num2}
        // pair: with all elements 4m Array1 with 1st element of array2 i.e. array2[0] and index of array2 in use
        for(int i=0; i < array1.length && i<k; i++){ //we don't need more then k items from array1
            pq.offer(new int[] {array1[i], array2[0], 0}); // allElementsOfArr1, firstFromArr2, indexOfArr2InUsed
        }

        //until now pq have K numbers of pairs with minimum K elements from array1 + first element of array2
        // next better pair could with be A: {after(num1), num2} or B: {num1. after(num2)}
        // so for sure we have at-lest one smallest pair i.e allElementsOfArr1 + firstElementOfArr2
        // for A, we've already added top possible k into queue, so A is either in the queue already, or not qualified
        // for B, it might be a better choice, so we offer it into queue
        while(k-- > 0 && !pq.isEmpty()){ //we loop until we get K pair or PQ is empty
            int[] cur = pq.poll();
            int curArrOneNum = cur[0];
            int curArrTwoNum = cur[1];
            int curArrTwoIndex = cur[2];

            result.add(new int[]{curArrOneNum, curArrTwoNum});
            // now lets check with curArrOne and nextArrTwo
            int nextArrayTwoIndex = curArrTwoIndex+1;
            if(nextArrayTwoIndex < array2.length-1){
                pq.offer(new int[] {curArrOneNum, array2[nextArrayTwoIndex], nextArrayTwoIndex});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{1,7,8,16};
        int[] array2 = new int[]{2, 3, 10, 15};
        List<int[]> result = kSmallestPairs(array1, array2, 4);
        for(int[] cur: result){
            System.out.println(Arrays.toString(cur));
        }
     }
}
