/* [ Type1 K-sack 02 ] [ Subset Sum Problem ]
_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
← ↑ → ↓ ↖ ↘ ↗ ↙   ●  ○ ∞
Given a set of non-negative integers, and a value sum, determine if there is a subset of the
given set with sum equal to given sum.
    
    Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
    Output: True
    There is a subset (4, 5) with sum 9.
    
    Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
    Output: False
    There is no subset that add up to 30.
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.Arrays;

public class _DP_T1_02_Subset_Sum_K {
    /*
            This problems follows the pattern of bounded Knapsack
            how? -> have Choice, have a item arr, have target
     */
    
    // First start with Recursive code
    public static boolean subsetSumRecursion(int[] arr, int target){
        return subsetSumRecursionHelper(arr, target, arr.length-1);
    }
    
    private static boolean subsetSumRecursionHelper(int[] arr, int target, int n) {
        //base case: two variables target and size for each recursion call
        // If the target is 0 i.e. If ( target =0 yes we can achieve it by empty set)
        // if the size of array == 0; if we don't have elements how do we find sum
        if (target ==0) return true;
        if (n == 0) return false;
        
        /*Exclude: If last element is greater than sum, then ignore it*/
        if(arr[n-1] > target){
            return subsetSumRecursionHelper(arr, target, n-1);                          //exclude
        }
        /*Include Case: check if sum can be obtained by any of the following
                        (a) including the last element
                        (b) excluding the last element          */
        return subsetSumRecursionHelper(arr, target - arr[n-1], n-1) ||          //include
                       subsetSumRecursionHelper(arr, target, n-1);                        //exclude
    }
    
/*_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _*/
/*_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _*/
    
    // Second Step: Recursive code ---> remove repeating subProblem to memoization
    public static boolean subsetSumMemoization(int[] arr, int target){
        //boolean[][] dp = new boolean[target+1][arr.length+1];  not able to use boolean because i need default value null or -1
        int [][] dp = new int[target+1][arr.length+1];
        for(int i =0; i<dp.length; i++){
            for(int j =0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        int i = subsetSumMemoHelper(arr, target, arr.length, dp);
        return i==1?true:false;
    }
    
    private static int subsetSumMemoHelper(int[] arr, int target, int n, int[][] dp) {
        //base case: two variables target and size for each recursion call
        // If the target is 0 i.e. If ( target =0 yes we can achieve it by empty set)
        // if the size of array == 0; if we don't have elements how do we find sum
        if (target ==0) return 1; //1=true
        if (n <= 0) return 0;
        if (dp[target][n-1] != -1){
            return dp[target][n-1];
        }
        /*Exclude: If last element is greater than sum, then ignore it*/
        if(arr[n-1] > target){
            return dp[target][n-1] = subsetSumMemoHelper(arr, target, n-1, dp);
        }
        /*Include Case: check if sum can be obtained by any of the following
                        (a) including the last element
                        (b) excluding the last element          */
        
       if(subsetSumMemoHelper(arr, target-arr[n-1], n-1, dp) != 0       //--> including
                  ||   subsetSumMemoHelper(arr, target, n-1, dp) !=0){           //--> excluding
           dp[target][n-1] = 1;
       }else
           dp[target][n-1] =0;
        
       return dp[target][n-1];
    }
    
/*_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _*/
/*_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _*/
    
    // Third Step: Recursive code ---> remove repeating subProblem to memoization --> remove recursive to memory
    //https://youtu.be/tRpkluGqINc?t=143
    public static boolean subsetSumDP(int[] arr, int n, int sum){
        boolean[][] dp = new boolean[n+1][sum+1]; //--> learned in last two approach
        
        for(int r =0; r< dp.length; r++){
            for(int c=0; c<dp[0].length; c++){
                // creating default values:
                if(r==0 && c ==0){
                    dp[r][c] = true; //leftMostCorner: we have 0 elements and target 0 yes it possible []->emptySet
                }else if(r==0){
                    dp[r][c] = false; //Top row: Given elements 0 and asking to make something not possible
                }else if(c==0){
                    dp[r][c] = true;  // LeftMostCol: else elements has a empty set.
                }else{ //--> lets fill remaining
                    //Exclude: if target is achieved without including currentElement
                    if(dp[r-1][c]==true){
                        dp[r][c] = true;
                    }
                    //Include:
                    else{
                        int curVal = arr[r-1];
                        if(curVal <= c){
                            if(dp[r-1][c-curVal]==true)
                                dp[r][c] = true;
                        }
                    }
                }
            }
        }
        return dp[arr.length][sum]; // return last cell value
    }
    
    public static void main(String[] args) {
        
        int[] arr = new int[]{2,3,4, 7,10};
        int target = 11;
        System.out.println(subsetSumRecursion(arr, target));
        System.out.println(subsetSumMemoization(arr, target));
        System.out.println(subsetSumDP(arr, arr.length, target));
       
    }
}
