/* [ _DP_01_ ] [ Longest Palindromic Subsequence ]
________________________________________________________________________________________________________
 What is the longest palindromic subsequence?
 The longest palindromic subsequence is the longest sequence of characters in a string that spells
 the same forwards and backward. A subsequence differs from a substring since characters in a subsequence
 are not required to be at consecutive positions in the original string.

 Example
 Take string "ABBCDABBCA", for example. Then the longest palindromic subsequence in this string is "ABBABBA".
              ↑↑↑  ↑↑↑ ↑


 */
package _00_Problems_Sorted_By_Patterns;
public class _DP_01_Longest_Palindromic_SubSequence_Recursion_Memoization_DP {

    /*=============   Method 1  ====================================*/
    // recursive solution(Top- down approach) time complexity - O(2^(m+n)) space complexity - O(m+n)
    static int LCSubsequence_topDown(String str){
        if (str == null) return 0;
        return LCSubsequence_topDown(str, 0, str.length()-1);
    }

    static int LCSubsequence_topDown(String str, int i, int j){
        // base condition
        if(i>j) return 0;

        // if String X has only one character, it is palindrome
        if(i==j) return 1;

        // if last character of the string is same as the first character
        if(str.charAt(i)==str.charAt(j)){
            // include first and last characters in palindrome
            // and recur for the remaining substring X[i+1, j-1]
            return 2+ LCSubsequence_topDown(str, i+1, j-1);
        }

        /* if last character of string is different to the first character
              return maximum of -
        // 1. Remove last character & recur for the remaining substring X[i, j-1]
        // 2. Remove first character & recur for the remaining substring X[i+1, j] */
        return Math.max(LCSubsequence_topDown(str, i+1, j),
                LCSubsequence_topDown(str, i, j-1));
    }

    /*=============   Method 2  ====================================*/
    // recursive solution(Top- down approach) time complexity - O(2^(m+n)) space complexity - O(m+n)
    static int LCSubsequence_topDownWithMemoization(String str){
        if (str == null) return 0;
        int[][] dp = new int[str.length()][str.length()];
        for(int i =0; i<dp.length; i++){
            for(int j =0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return LCSubsequence_topDownWithMemoization(str, 0, str.length()-1, dp);
    }
    static int LCSubsequence_topDownWithMemoization(String str, int left, int right, int[][]dp){
        // base condition
        if(dp[left][right] != -1) {
            return dp[left][right];
        }
        if(left>right)
            return 0;
        // if String X has only one character, it is palindrome
        if(left==right)
            return 1;

        // if last character of the string is same as the first character
        if(str.charAt(left)==str.charAt(right)){
            // include first and last characters in palindrome
            // and recur for the remaining substring X[left+1, right-1]
            return dp[left][right] = 2 + LCSubsequence_topDownWithMemoization(str, left+1, right-1, dp);
        }

        /* if last character of string is different to the first character
              return maximum of -
        // 1. Remove last character & recur for the remaining substring X[left, right-1]
        // 2. Remove first character & recur for the remaining substring X[left+1, right] */
        dp[left][right] = Math.max(LCSubsequence_topDownWithMemoization(str, left+1, right, dp),
                LCSubsequence_topDownWithMemoization(str, left, right-1, dp));

        return dp[left][right];
    }

    /*=============   Method 3  ====================================*/
    /*
     DP logic: dp[i][j]: the longest palindromic subsequence's length of substring(i, j),
         here i, j represent left, right indexes in the string
         State transition:
         dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
         otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
         Initialization: dp[i][i] = 1
     */
    static int longestPalindromicSubsequence(String s){
        int[][] dp = new int[s.length()][s.length()];

        //fill the matrix from right bottom corner
        for(int i =s.length()-1; i>=0; i--){
            //Initialization
            dp[i][i] = 1;
            // as we just need to fill the right diagonally half from bottom
            for(int j= i+1; j<s.length();j++){
                //cases 1: if same char bottom left + 2
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] =  dp[i+1][j-1] + 2;
                }
                else{
                    //cases 2: max of left and bottom
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        //return right top corner as we are fill the matrix from bottom up
        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(LCSubsequence_topDown("axbdba"));
        System.out.println(LCSubsequence_topDownWithMemoization("axbdba"));
        System.out.println(longestPalindromicSubsequence("axbdba"));
    }

}
