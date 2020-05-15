/**
 * [ DP_02 ] [ _02_ByteBy_Square_Submatrix ]
 * ____________________________________________________________________________________________________________
 Given a 2D boolean array, find the largest square subarray of true values. You
 should return the side length of the largest square subarray.
 ● n x m array
 ● Constant time operation on each cell
 ● Time complexity is O(n * m)
 ● Space complexity is O(n * m)
 */
package DynamicProgramming;
public class _02_ByteBy_Square_Submatrix {

    static int squareSubmatrix(boolean[][] matrix){
       int[][] dp = new int[matrix.length][matrix[0].length];
       int maxSize =0;

       for(int r =0; r<matrix.length; r++){
           for(int c=0; c<matrix[0].length; c++){
               //boundary case: if true put 1 else 0
               if(r==0 || c==0){
                   dp[r][c] = matrix[r][c] == true?  1 : 0;
               }
               // compute only if true : calculate the current value by looking at
               //dp[r][c-1],dp[r-1][c]),dp[r-1][c-1]
               else if(matrix[r][c]) {
                   dp[r][c] = 1+ Math.min(Math.min(dp[r][c-1],dp[r-1][c]),dp[r-1][c-1]);
               }
                maxSize = Math.max(maxSize, dp[r][c]);
           }
       }
       return maxSize;
    }

    public static void main(String[] args) {
        boolean[][] matrix = new boolean[][]{
            {true,  false, false, false, false},
            {true,  false, true,  true,  true},
            {false, false, true,  true,  true},
            {true,  false, true,  true,  true},
            {true,  true,  true,  true,  true}
        };
        System.out.println(squareSubmatrix(matrix));
    }
}
