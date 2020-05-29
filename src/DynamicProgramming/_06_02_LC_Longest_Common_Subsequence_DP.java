/**
 * [ _06_01 ] [ Longest Common Subsequence  ]
 ______________________________________________________________________________________________________________
 Given two strings text1 and text2, return the length of their longest common subsequence.
 //Approach 3 : Bottom's Up DP */
 /*Remembering back to previous Approach
 there were two cases.
       1. The first letter of each string is the same.
       2. The first letter of each string is different.
 For the first case: we solve the subproblem that removes the first letter
 from each, and add 1. In the grid, this subproblem is always the diagonal immediately up and left.

 For the second case: we consider the subproblem that removes the first letter off the first word,
 and then the subproblem that removes the first letter off the second word. In the grid, these are
 subproblems immediately left and up.
 */
package DynamicProgramming;
public class _06_02_LC_Longest_Common_Subsequence_DP {

    static int LCS_DP(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i =0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){

                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                // case first
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }
                else{ // second cases
                    dp[i][j] =  Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    public static void main(String[] args) {
        System.out.println(LCS_DP("adabd", "adb"));

    }
}
