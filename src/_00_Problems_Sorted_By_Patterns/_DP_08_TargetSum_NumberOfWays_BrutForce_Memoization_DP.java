package _00_Problems_Sorted_By_Patterns;/* [  ] [ Target Sum number of ways | Counting problem ]
_______________________________________________________________________________

Given an array of integers, nums, and a target value, T, find the number of ways
that you can add and subtract the values in nums to sum to T.
eg.
        nums = {1, 2, 3, 4}   |    Target  = 0

        1 - 2 - 3 + 4
        -1 + 2 + 3 - 4

*/

public class _DP_08_TargetSum_NumberOfWays_BrutForce_Memoization_DP {
         /* ===================    Method 1   Recursion BruteForce  ======================================
                ● Time complexity is O(2^n)
                ● Space complexity is O(n)         */

        //Similar to 0-1 Knapsack, where we include or exclude each item
    public static int targetSumNumberOfWaysRecursion(int[] arr, int target) {
        return targetSumRecursionHelper(arr, target, 0, 0);
    }

    private static int targetSumRecursionHelper(int[] arr, int target, int index, int curSum) {
        if(index == arr.length){
            return curSum==target? 1:0;
        }
        // Case 1. Include current element in total sum [+]
        int include = targetSumRecursionHelper(arr, target, index+1, curSum+ arr[index]);

        // Case 2. Exclude current element in total sum [-]
        int excluded = targetSumRecursionHelper(arr, target, index+1, curSum- arr[index]);

        // return total ways by including or excluding current coin
        return include + excluded;
    }





        /* ===================    Method 2   Memoization  ======================================
                ● Number of possible subproblems is n * sum(nums)
                ● Time complexity is O(n * sum(nums))
                ● Space complexity is O(n * sum(nums))
                ○ Could be improved by using a HashMap   */







        /* ===================    Method 3   DP ===================================================
                ● Time complexity is O(n * W)
                ● Space complexity is O(n * W)

           Logic: Turn around the solution
                ● Flip around the subproblem definition
                    ○ knapsack(W, i) is the maximum value of the first i items (items from 0 to i) that weigh less
                    than W
                ● Base cases
                    ○ W == 0. No weight means no value
                    ○ i == 0. No items means no value           */


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(targetSumNumberOfWaysRecursion(arr, 0));
    }
}
