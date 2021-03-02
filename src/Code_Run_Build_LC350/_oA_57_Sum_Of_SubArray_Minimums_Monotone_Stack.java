/* [ _oA_57_] [ Sum of Sub Array Minimums Monotone Stack ]
_______________________________________________________________________________
Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.
Example 1:

Input: [3,1,2,4]
Output: 17
Explanation: Sub arrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.

Logic:
               consider 3
                    |
       [2, 9, 7, 8, 3, 4, 6, 1]
        |                    |
    the previous less      the next less
     element of 3           element of 3

calculation:
how far is previous less [left of 3(3isAtIndex4)] (the element lessThan 3 is 2, which is at index 0, so DistCal will be 4-0 = 4
how far is next less [Right of 3(3isAtIndex4)] (the element lessThan 3 is 1, which is at index 4, so DistCal will be 7-4 = 3
so total subArray we can make using 3 as minimum is 4*3=12 and sum would be 3*12 = 36
*/
package Code_Run_Build_LC350;

import java.util.Stack;

public class _oA_57_Sum_Of_SubArray_Minimums_Monotone_Stack {
    public static int minSumSubArray(int[] arr){
        int result=0;
        int len = arr.length;
        // previousLess is for the distance to previous less element
        int[] previousLess = new int[len];
        // nextLess is for the distance to next less element
        int[] nextLess = new int[len];

        Stack<Integer> stack = new Stack<>();

        // fill previousLess using Monotone stack logic (same logic as previous rainWater and other monotone stack
        for(int i =0; i<len; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            previousLess[i] = stack.isEmpty()? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        // fill nextLess
        for(int i=len-1; i>=0; i-- ){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            nextLess[i] = stack.isEmpty()? len : stack.peek();// if stack is empty that means last one is smallest
            stack.push(i);
        }
        // calculate minSubArraySum
        int mod = (int)1e9 + 7;
        for(int i = 0; i < len; i++) {
            result = (result + arr[i] * (i-previousLess[i]) * (nextLess[i]-i)) % mod;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,8,9,3,4,1};
        System.out.println(minSumSubArray(arr));
    }
}

