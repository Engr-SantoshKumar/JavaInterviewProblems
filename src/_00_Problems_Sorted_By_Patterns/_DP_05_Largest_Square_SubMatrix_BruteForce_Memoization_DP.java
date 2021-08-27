/* [  ] [ largest square subarray ]
_______________________________________________________________________________
Given a 2D boolean array, find the largest square subarray of true values. You
should return the side length of the largest square subarray.
Input: matrix = [["1","0","1","0","0"],
                ["1","0","1","1","1"],
                ["1","1","1","1","1"],
                ["1","0","0","1","0"]]
Output: 4

arr = squareSubmatrix(arr) = 2 from 1,1 to 2,2
*/
package _00_Problems_Sorted_By_Patterns;

import java.sql.Time;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class _DP_05_Largest_Square_SubMatrix_BruteForce_Memoization_DP {

/* ===================    Method 1   Recursion BruteForce  ======================================
             ● Time complexity
                        ○ Branching factor is 3
                        ○ Height is n + m (row + col)
                        ○ We repeat recursion for each cell
                        ○ O(n * m * 3n+m)
            ● Space complexity is O(n+m)
      */

    public static int largestSquareSubMatrix_Recursion(int[][] matrix){
        int max =0;
        for(int i=0; i<matrix.length; i++){
            for(int j =0; j<matrix[0].length; j++){
                //call the helper for each cell
                max = Math.max(max, helperRecursion(matrix, i, j));
            }
        }
        return max;
    }

    private static int helperRecursion(int[][] matrix, int row, int col) {
        // boundary check and call value check

        if(row>=matrix.length || col>=matrix.length)
            return 0;
        if(matrix[row][col] ==0)
            return 0;

        //recursive calls for bottom, right and coroner
        return 1+ Math.min(Math.min(helperRecursion(matrix, row + 1, col),
                helperRecursion(matrix, row, col + 1)),
                helperRecursion(matrix, row+1, col+1));
    }


/* ===================    Method 2   Memoization  ======================================
            ● Time complexity is O(n * m)
            ● Space complexity is O(n * m)
      */

    public static int largestSquareSubMatrix_Memoization(int[][] matrix){
        int max =0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for(int i=0; i<matrix.length; i++){
            for(int j =0; j<matrix[0].length; j++){
                //call the helper for each cell
                max = Math.max(max, helperMemoization(matrix, i, j, dp)); //--------------new update with dp
            }
        }
        return max;
    }

    private static int helperMemoization(int[][] matrix, int row, int col, int[][]dp) {
        // boundary check and call value check
            if(row>=matrix.length || col>=matrix.length)
                return 0;
            if(matrix[row][col] ==0)
                return 0;
            if(dp[row][col]==0){
                //recursive calls for bottom, right and coroner
                dp[row][col]= 1+ Math.min(Math.min(helperMemoization(matrix, row + 1, col, dp),
                        helperMemoization(matrix, row, col + 1, dp)),
                        helperMemoization(matrix, row+1, col+1, dp));
            }
        return dp[row][col];
    }

/* ===================    Method 2   Memoization using Map  ======================================
            ● Time complexity is O(n * m)
            ● Space complexity is O(n * m)
      */

    public static int largestSquareSubMatrix_MemoizationMap(int[][] matrix){
        int max =0;
        //lets use map to store calculated values
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<matrix.length; i++){
            for(int j =0; j<matrix[0].length; j++){
                //call the helper for each cell
                max = Math.max(max, helperMemoizationMap(matrix, i, j, map)); //--------------new update with dp
            }
        }
        return max;
    }

    private static int helperMemoizationMap(int[][] matrix, int row, int col, HashMap<String, Integer> map) {
        // boundary check and call value check
        if(row>=matrix.length || col>=matrix.length)
            return 0;
        if(matrix[row][col] ==0)
            return 0;
        // construct a unique map key from dynamic elements of the input
        String key = row + "|" + col;
        if(!map.containsKey(key)){
            int curSubSquire = 1+ Math.min(Math.min(helperMemoizationMap(matrix, row + 1, col, map),
                    helperMemoizationMap(matrix, row, col + 1, map)),
                    helperMemoizationMap(matrix, row+1, col+1, map));
            map.put(key, curSubSquire);
        }
        return map.get(key);
    }

/* ===================    Method 3   DP ===================================================
            ● Time complexity is O(n * m)
            ● Space complexity is O(n * m)

      Logic: Turn around the solution
            ● Currently we recurse to the end of the array and work backwards
            ● Let’s flip it and say squareSubMatrix(i, j) is the largest square subMatrix
                    -  where i, j is the bottom right-hand corner
            ● Our new base case is i = 0 or j = 0, which is 1 if arr[i][j] == True  and 0 otherwise
      */

    public static int largestSquareSubMatrix_DP(boolean[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] ? 1 : 0;
                } else if (matrix[i][j]) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1],
                            dp[i-1][j]),
                            dp[i-1][j-1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }












    public static void main(String[] args) {
        int [][] matrix = {{'1','0','1','0','0'},
                           {'1','0','1','1','1'},
                           {'1','1','1','1','1'},
                           {'1','0','0','1','0'}};

        System.out.println(largestSquareSubMatrix_Recursion(matrix));
        System.out.println(largestSquareSubMatrix_Memoization(matrix));
        System.out.println(largestSquareSubMatrix_MemoizationMap(matrix));
    }



}
