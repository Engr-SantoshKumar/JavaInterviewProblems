/**
 * [ DP_07_01 ] [ Longest Palindromic Subsequence ]
 * _________________________________________________________________________________________________________
 What is the longest palindromic subsequence?
 The longest palindromic subsequence is the longest sequence of characters in a string that spells
 the same forwards and backward. A subsequence differs from a substring since characters in a subsequence
 are not required to be at consecutive positions in the original string.

 Example
 Take string "ABBCDABBC", for example. Then the longest palindromic subsequence in this string is "BBABB".

 This problem is almost same as previous problem here we are compering chatAt i, j withIn string +
 also if char matches we are incrementing the count by 2

 */
package DynamicProgramming;
public class _07_01_LC_Longest_Palindromic_Subsequence_recursion {
    //Method 1:
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

    //Method 2:
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

    static int LCSubsequence_topDownWithMemoization(String str, int i, int j, int[][]dp){
        // base condition
        if(dp[i][j] != -1) return dp[i][j];
        if(i>j) return 0;

        // if String X has only one character, it is palindrome
        if(i==j) return 1;

        // if last character of the string is same as the first character
        if(str.charAt(i)==str.charAt(j)){
            // include first and last characters in palindrome
            // and recur for the remaining substring X[i+1, j-1]
            dp[i][j] = 2+ LCSubsequence_topDown(str, i+1, j-1);
        }

        /* if last character of string is different to the first character
              return maximum of -
        // 1. Remove last character & recur for the remaining substring X[i, j-1]
        // 2. Remove first character & recur for the remaining substring X[i+1, j] */
        dp[i][j] = Math.max(LCSubsequence_topDown(str, i+1, j),
                LCSubsequence_topDown(str, i, j-1));

        return dp[i][j];
    }

    public static void main(String[] args) {
        System.out.println(LCSubsequence_topDown("ABBCDABBC"));
        System.out.println(LCSubsequence_topDownWithMemoization("ABBCDABBC"));
    }
}

