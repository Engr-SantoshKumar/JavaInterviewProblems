/* [ _Heaps_05_ ] [ _Heaps_05_Sliding_Window_Maximum ]
_______________________________________________________________________________
You are given an array of integers nums, there is a sliding window of size k which is moving from
the very left of the array to the very right. You can only see the k numbers in the window.
Each time the sliding window moves right by one position.

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
    Window position                i[v]        Max            indexQ        Val
    ---------------               ---      -----                        -----
i->  0  1   2   3  4  5  6  7      -        -               -

     1  3  -1  -3  5  3  6  7      0[1]        -               0            1
     1  3  -1  -3  5  3  6  7      1[3]        -               1            3         1 out 3 in  --> step 2
    [1  3  -1] -3  5  3  6  7      2[-1]       3(frontOne)     2,1         -1, 3
     1 [3  -1  -3] 5  3  6  7      3[-3]       3               3,2,1       -3,-1,3    outOfBoundary idx 0 but its already removed
     1  3 [-1  -3  5] 3  6  7      4[5]        5               4           5          incoming i4 v5 --> indexOf -3,-1,3 out step2
     1  3  -1 [-3  5  3] 6  7      5[3]        5               5,4         3,5
     1  3  -1  -3 [5  3  6] 7      6[6]        6               6           6         incoming 6 --> all smaller val out 3, 5 out
     1  3  -1  -3  5 [3  6  7]      7[7]       7               7           7         incoming 7 --> all smaller val out 6 out
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _Heaps_05_Sliding_Window_Maximum {
    public static int[] maxSlidingWindow(int[] array, int k) {
        if (array == null || k <= 0) {
            return new int[0];
        }
        int n = array.length;
        int[] result = new int[n-k+1];
        int resultIndex = 0;
        //  1. Use array deque to store the indexes and make sure head has the largest number
        Deque<Integer> q = new ArrayDeque<>();
        for (int end = 0; end < array.length; end++) {
            int incoming = array[end];
            // outOfRange : Check head element to see if they are >= (end - k + 1) range. If not, remove head
            if (!q.isEmpty() && q.peek() < end - k + 1) {
                q.poll(); // as its queue so FIFO
            }
            // Step 2: For each incoming element, we first check whether it's bigger than the nums[last element] of dq.
            // If so, continue to remove from last --> array[last element] of dq
            while (!q.isEmpty() && array[q.peekLast()] < incoming) {
                q.pollLast();
            }
            // add to queue
            q.offer(end);
            // add to result
            if (end >= k - 1) {
                result[resultIndex++] = array[q.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,3,-1,-3,5,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(array, 3)));
    }
}
