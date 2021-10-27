package _00_Problems_Sorted_By_Patterns;/* [  ] [  ]
_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
← ↑ → ↓ ↖ ↘ ↗ ↙   ●  ○ ∞
There are several cards arranged in a row, and each card has an associated number of points.
The points are given in the integer array cardPoints.
In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
Each move # is associated with a score multiplier. you gain points equal to the card value multiplied by the score multiplier for that move..
Given the integer array cardPoints, multiplayer and integer k(length of multiplayer array), return the maximum score you can obtain.

Input: cardPoints = [1,2,3,4,5,6,1], multiplayer = [1,3,2]
Output: 1*1 + 6*3 + 5*2 =  29

Input: cardPoints = [4,2,1,4,3,6,0], multiplayer = [1,3,2]
OutPut: 0*1 + 6*3 + 4*2 =  26

*/

public class _DP_10_Maximum_Points_You_Can_Obtain_from_CardsMultiplayer {
    /* ===================    Method 1   Recursion BruteForce  ======================================
       ● Time complexity is O(2^k)
           ○ Branching factor is 2
           ○ Height is k (no of elements to pick)
       ● Space complexity is O(k) recursion stack
    */
    public static int maxScoreRecursion(int[] arr, int[] multi, int k) {
        return maxScoreRecursionHelper(arr, 0,arr.length - 1, multi, 0, k);
    }
    
    private static int maxScoreRecursionHelper(int[] arr, int left, int right, int[]multi, int curr, int k) {
        if(k==0) return 0;
        int leftVal = arr[left]*multi[curr] +
                              maxScoreRecursionHelper(arr, left+1, right, multi, curr+1, k-1 );
        
        int rightVal   = arr[right]*multi[curr] +
                                 maxScoreRecursionHelper(arr, left, right-1, multi, curr+1, k-1 );
        
        return Math.max (leftVal, rightVal);
        
    }
    /* ===================    Method 2   Memoization  ======================================
        ● Time complexity is O(K^2)
        ● Space complexity is O(K^2), O(K) if BFS
    */
    
    public static int maxScore(int[] arr, int k, int[] mf) {
        int n = arr.length;
        Integer[][] dp = new Integer[n][n];
        return helperDP(arr, 0, n-1, k, dp, mf, 0);
    }
    
    private static int helperDP(int[] arr, int l, int r, int k, Integer[][]dp, int[] mf, int cur) {
        if(k==0) return 0;
        if(dp[l][r] != null) return dp[l][r];
        
        int leftV = arr[l]*mf[cur] + helperDP(arr, l+1, r, k-1, dp, mf, cur+1);
        int rightV = arr[r]*mf[cur]+ helperDP(arr, l, r-1, k-1, dp, mf, cur+1);
        
        return dp[l][r]= Math.max(leftV, rightV);
    }
    
        /* ===================    Method 2   Memoization memory optimization ======================================
        ● Time complexity is O(K^2)
        N: 10^5, M: 10^3. dp[N][N] will make us out of memory.
        Observation: the range of left is at most [0, K], the range of j is at most [N - K, N).
        So that, we could use dp[K][K] rather than dp[N][N] to save a lot of space (just need to "normalize" the right pointer a little bit)
    */
        public static int maxScoreOpt(int[] arr, int k, int[] mf) {
            int n = arr.length;
            int m = mf.length;
            Integer[][] dp = new Integer[k][k];
            return helperDpOpt(arr, 0, n-1, k, dp, mf, 0, n, m);
        }
    
    private static int helperDpOpt(int[] arr, int l, int r, int k, Integer[][]dp, int[] mf, int cur, int arrLen, int mfLen) {
        if(k==0) return 0;
        if(dp[l][r-(arrLen-mfLen)] != null) return dp[l][r-(arrLen-mfLen)];
        
        int leftV = arr[l]*mf[cur] + helperDpOpt(arr, l+1, r, k-1, dp, mf, cur+1, arrLen, mfLen);
        int rightV = arr[r]*mf[cur]+ helperDpOpt(arr, l, r-1, k-1, dp, mf, cur+1, arrLen, mfLen);
        
        return dp[l][r-(arrLen-mfLen)]= Math.max(leftV, rightV);
    }
    
    public static int maxPointSpaceN(int[] arr, int[] multipliers, int k){
        int n = arr.length;
        int m = multipliers.length;
        int[] dp = new int[n];
        int curIndex = m-1;
        for(int len = n-m+1; len <= n; len ++){
            int[] temp = new int[dp.length];
            for(int l = 0; l <= n-len; l++){
                int r = l + len -1;
                if(l == r){
                    temp[l] =  Math.max(arr[l] * multipliers[curIndex],
                                        arr[r] * multipliers[curIndex]);
                }
                else{
                    temp[l] = Math.max(arr[l] * multipliers[curIndex] + dp[l+1],
                                       arr[r] * multipliers[curIndex]+ dp[l]);
                }
            }
            curIndex --;
            dp = temp;
        }
        return dp[0];
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 1, 7, 0};
        int[] multiplier = new int[]{1,3,2};
        System.out.println(maxScoreRecursion(arr, multiplier, 3));
        System.out.println(maxScore(arr, 3, multiplier));
        System.out.println(maxScoreOpt(arr, 3, multiplier));
        System.out.println(maxPointSpaceN(arr, multiplier, 3));
    }
}
