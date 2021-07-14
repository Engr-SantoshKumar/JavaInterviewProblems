/* [ _DP_03_  ] [ Number of Longest Increasing Subsequence ]
_______________________________________________________________________________
Given an integer array nums, return the number of longest increasing subsequences.

Input: nums = [1,3,5,4,7] o/p =2
The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
Logic:  Element at i will be part of subsequence only if
       1. arr[i] is grater than previous(last) element of subsequence
       2. length of subsequence w/o arr[i] + 1 is grater than length at i
           --> Length[j] +1 > length[i] ..because then only it will increase the size of subsequence

 */
package _00_Problems_Sorted_By_Patterns;
import java.util.Arrays;

public class _DP_03_Number_of_Longest_Increasing_Subsequence {
    public static int longestIncreasingSubsequence(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        // dp[i] is the longest increasing subsequence ending with element i. dp[i][0] is length of LIS,
        // dp[i][1] is number of LIS'.
        int[][] dp = new int[nums.length][2];
        int numLIS = 0, lengthLIS = 0;
        for (int i = 0; i < nums.length; ++i) {
            // Initial values are 1 because every element alone by itself forms a LIS of length 1.
            dp[i][0] = 1;
            dp[i][1] = 1;
            // This loop iterates through all LIS' that end at previous elements j to compute the LIS'
            // that end at the current element i.
            for (int j = 0; j < i; ++j) {
                // Check if LIS ending with element j can be extended by element i.
                if (nums[j] < nums[i]) {
                    if (dp[j][0] + 1 == dp[i][0]) {
                        // When extending dp[j] we get subsequences of the same length as the current LIS so we just update the number of them.
                        dp[i][1] += dp[j][1];
                    } else if (dp[i][0] < dp[j][0] + 1) {
                        // By extending dp[j] with element i we get longer subsequences ending at i than the ones known so far.
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                    }
                }
            }
            // Now that we have all the LIS' that end at element i we check how this influences the result
            // (new max length is found or more of the already known max length is found)
            if (lengthLIS < dp[i][0]) {
                lengthLIS = dp[i][0];
                numLIS = dp[i][1];
            } else if (lengthLIS == dp[i][0]) {
                numLIS += dp[i][1];
            }
        }
        return numLIS;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,3,7,8,9,2,3,4,7,10};
        System.out.println(longestIncreasingSubsequence(arr));
    }

}

