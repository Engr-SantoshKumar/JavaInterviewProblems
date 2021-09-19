/* [ _002_ ] [ Sliding Window Median ]
_______________________________________________________________________________
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
Explanation:
Window position                Median
---------------                -----
[1  3  -1] -3  5  3  6  7        1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7        3
 1  3  -1  -3 [5  3  6] 7        5
 1  3  -1  -3  5 [3  6  7]       6

 Inspired by this solution. to the problem: 295. Find Median from Data Stream

However instead of using two priority queue's we use two Tree Sets as we want O(logk) for remove(element).
PQ would have been O(k) for remove(element) giving us an overall time complexity of O(nk) instead of O(nlogk).

However there is an issue when it comes to duplicate values so to get around this we store the
index into nums in our Tree Set. To break ties in our Tree Set comparator we compare the index.
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _HeapsTwo_002_Sliding_Window_Median {
    /** initialize your data structure here. */
    //1st half (left half) this will be in reverse order (max heap)
    static PriorityQueue<Integer> firstHalf = new PriorityQueue<>((a, b) -> b - a);
    //2nd half (Right half) sorted in natural order
    static PriorityQueue<Integer> secondHalf = new PriorityQueue<>();


    public static double[] medianSlidingWindow(int[] arr, int k) {
        double[] medianResult = new double[arr.length-k+1];
        int index=0;

        for(int i=0; i<arr.length; i++){
            firstHalf.offer(arr[i]);
            // idea is to bring the elements to 2nd half through 1st half, so that the bigger elements will come
            secondHalf.offer(firstHalf.remove());
            //now balance both (we always try to have extra at first half)
            if(secondHalf.size() > firstHalf.size()){
                // top of 2nd half become top of 1st half
                firstHalf.offer(secondHalf.remove());
            }
            //check if we have window size
            if(i>=k-1) {
                //update result array
                if (firstHalf.size() == secondHalf.size()) {
                    medianResult[index++] = (double) (firstHalf.peek() + secondHalf.peek()) / 2;
                } else {
                    medianResult[index++] = firstHalf.peek(); // we always try to have extra at first half
                }
                //Last step slide window i.e remove the last element of window i.t i-k+1
                int numToRemove = arr[i - k + 1];
                //check where this numToRemove could be
                if (numToRemove <= firstHalf.peek()) {
                    firstHalf.remove(numToRemove);
                } else {
                    secondHalf.remove(numToRemove);
                }
            }
        }
        return medianResult;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3,  -1, -3,  5,  3,  6,  7 };
        System.out.println(Arrays.toString(medianSlidingWindow(arr, 3)));
    }
}
