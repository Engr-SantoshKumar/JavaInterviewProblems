/* [  ] [ Maximum Points You Can Obtain from Cards ]
_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
← ↑ → ↓ ↖ ↘ ↗ ↙   ●  ○ ∞
There are several cards arranged in a row, and each card has an associated number of points.
The points are given in the integer array cardPoints.
In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
Your score is the sum of the points of the cards you have taken.
Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1.
However, choosing the rightmost card first will maximize your total score.
The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.

Input: cardPoints = [2,2,2], k = 2
Output: 4
Explanation: Regardless of which two cards you take, your score will always be 4.

*/
package _00_Problems_Sorted_By_Patterns;

import java.util.HashMap;
import java.util.Map;

public class _DP_09_Maximum_Points_You_Can_Obtain_from_Cards {
    
    /* ===================    Method 1   Recursion BruteForce  ======================================
       ● Time complexity is O(2^k)
           ○ Branching factor is 2
           ○ Height is k (no of elements to pick)
       ● Space complexity is O(k) recursion stack
    */
    public static int maxScoreRecursion(int[] arr, int k) {
        return maxScoreRecursionHelper(arr, 0,arr.length - 1, k);
    }
    
    private static int maxScoreRecursionHelper(int[] arr, int left, int right, int k) {
        if(k==0) return 0;
        int leftVal = arr[left] + maxScoreRecursionHelper(arr, left+1, right, k-1 );
        int rightVal   = arr[right] + maxScoreRecursionHelper(arr, left, right-1, k-1 );
        return Math.max (leftVal, rightVal);
        
    }
    /* ===================    Method 2   Memoization  ======================================
            ● Time complexity is O(K^2)
            ● Space complexity is O(K^2), O(K) if BFS
   */
    public static int maxScoreTopDownMemo_Array(int[] arr, int k) {
        Integer[][] dp = new Integer[arr.length][arr.length];
        return maxScoreTopDownMemoHelper_Array(arr, 0,arr.length - 1, k, dp);
    }

    private static int maxScoreTopDownMemoHelper_Array(int[] arr, int start, int end, int k, Integer[][] dp) {
        if (k == 0)
            return 0;
        if(dp[start][end] != null)
            return dp[start][end];
        
        int leftVal = arr[start] + maxScoreTopDownMemoHelper_Array(arr, start+1, end, k-1 , dp);
        int rightVal   = arr[end] + maxScoreTopDownMemoHelper_Array(arr, start, end-1, k-1 , dp);
        
        dp[start][end]= Math.max(leftVal, rightVal);
        return dp[start][end];
    }
    
    // using map
    public static int maxScoreTopDownMemo(int[] arr, int k) {
        return maxScoreTopDownMemoHelper(arr, 0,arr.length - 1, k);
        
    }
    static Map<String, Integer> map = new HashMap();
    private static int maxScoreTopDownMemoHelper(int[] arr, int l, int r, int k) {
        if (k == 0)
            return 0;
        String key = l + "|" + r;
        if (!map.containsKey(key)){
            int leftVal = arr[l] + maxScoreTopDownMemoHelper(arr, l+1, r, k-1 );
            int rightVal   = arr[r] + maxScoreTopDownMemoHelper(arr, l, r-1, k-1 );
            map.put(key, Math.max(leftVal, rightVal));
        }
        return map.get(key);
    }
     /* ===================    Method 3   DP ===================================================
                
                ● Time complexity: O(k) → Here we are using two for loops of length k to calculate the maximum possible score.
                                          This gives us O(2⋅k), which in Big O notation is equal to O(k).
                ● Space complexity: O(k) → Here we are using two arrays to store the total score obtained by selecting
                                            i(0<=i<k) cards from the beginning and i cards from the end.
                                            This gives us O(2⋅k), which is equal to O(k).
      */
     public static int maxScoreDP(int[] arr, int k) {
         int n = arr.length;
    
         int[] leftVal = new int[k + 1];
         int[] rightVal = new int[k + 1];
    
         for (int i = 0; i < k; i++) {
             leftVal[i + 1] = arr[i] + leftVal[i];
             rightVal[i + 1] = arr[n - i - 1] + rightVal[i];
         }
    
         int maxScore = 0;
         // Each i represents the number of element we picked from the front.
         for (int i = 0; i <= k; i++) {
             int currentScore = leftVal[i] + rightVal[k - i];
             maxScore = Math.max(maxScore, currentScore);
         }
         return maxScore;
     }
    
    /* ===================    Method 3   DP Space Optimization ===================================================
          
          ● Time complexity: O(k) → Here we are using two for loops of length k to calculate the maximum possible score.
                                    This gives us O(2⋅k), which in Big O notation is equal to O(k).
          ● Space complexity: O(1) → No extra space is used since all the calculations are done impromptu.
    */
    public static int maxScoreDPSpaceOptimization(int[] arr, int k) {
        int n = arr.length;
        
        int leftVal = 0;
        int rightVal = 0;
        
        for (int i = 0; i < k; i++) {
            leftVal += arr[i];
        }
        
        int maxScore = leftVal;
        // Each i represents the number of element we picked from the front.
        for (int i = k-1; i >=0; i--) {
            leftVal -= arr[i];
            rightVal += arr[n-(k-i)]; // arr[n7-(k3-i2)] = 6 which is lastIndex, 7-(3-1) = 5 (2ndLastInd), 7-(3-0) = 4 (3rdLast)
            int currentScore = leftVal+rightVal;
            maxScore = Math.max(maxScore, currentScore);
        }
        return maxScore;
    }
    
    
    
    
    public static void main(String[] args)
    {
        int[] arr = new int[]{ 4,2,1,7,0};
        //System.out.println(maxScoreRecursion(arr, 3));
        //System.out.println(maxScoreTopDownMemo(arr, 3));
        System.out.println(maxScoreTopDownMemo_Array(arr, 3));
        //System.out.println(maxScoreDP(arr, 3));
        //System.out.println(maxScoreDPSpaceOptimization(arr, 3));
    }
}
