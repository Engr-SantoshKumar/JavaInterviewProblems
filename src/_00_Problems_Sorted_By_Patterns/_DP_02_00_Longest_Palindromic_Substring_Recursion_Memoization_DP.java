/* [ _DP_02_Longest_ ] [ Longest palindromic Substring ]
_______________________________________________________________________________
Given a string s, return the longest palindromic substring in s.
Input: s = "babadc"
Output: "bab"
Note: "aba" is also a valid answer.
*/
package _00_Problems_Sorted_By_Patterns;
public class _DP_02_00_Longest_Palindromic_Substring_Recursion_Memoization_DP {

    /*=============   Method 1  ====================================*/
    // recursive solution(Top- down approach) time complexity - O(2^(m+n)) space complexity - O(m+n)
    static int longestPalindromic_Substring_topDown(String str){
        if (str == null) return 0;
        return longestPalindromic_Substring_topDown(str, 0, str.length()-1);
    }

    static int longestPalindromic_Substring_topDown(String str, int i, int j){
        // base condition
        if(i>j) return 0;

        // if String X has only one character, it is palindrome
        if(i==j) return 1;

        // if last character of the string is same as the first character
        if(str.charAt(i)==str.charAt(j)){
            int remainingStringLen = j-i-1;
            // char at i and j will be part of palindrome only if the inSides of i & j (i+1 and j-1) is also palindrome
            // how to find that --> if recursive call return the same len
            // e.g  aba --> remainingLen = i-j-1 =1 --> call recursion(i+1, j-1) --> i==j --> return 1
            if(remainingStringLen == longestPalindromic_Substring_topDown(str, i + 1, j - 1)){
                return 2+remainingStringLen;
            }
        }
        /* if last character of string is different to the first character
              return maximum of -
        // 1. Remove last character & recur for the remaining substring X[i, j-1]
        // 2. Remove first character & recur for the remaining substring X[i+1, j] */
        return Math.max(longestPalindromic_Substring_topDown(str, i+1, j),
                longestPalindromic_Substring_topDown(str, i, j-1));
    }

    /*=============   Method 2  ====================================*/
    // recursive solution(Top- down approach) time complexity - O(2^(m+n)) space complexity - O(m+n)
    static int longestPalindromic_Substring_Memoization(String str){
        if (str == null) return 0;
        int[][] dp = new int[str.length()][str.length()];
        for(int i =0; i<dp.length; i++){
            for(int j =0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return longestPalindromic_Substring_Memoization(str, 0, str.length()-1, dp);
    }
    static int longestPalindromic_Substring_Memoization(String str, int left, int right, int[][]dp){
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
        if(str.charAt(left)==str.charAt(right)) {
            int remainingStringLen = right - left - 1;

            // char at i and j will be part of palindrome only if the inSides of i & j (i+1 and j-1) is also palindrome
            // how to find that --> if recursive call return the same len
            // e.g  aba --> remainingLen = i-j-1 =1 --> call recursion(i+1, j-1) --> i==j --> return 1
            if (remainingStringLen == longestPalindromic_Substring_topDown(str, left + 1, right - 1)) {
                return dp[left][right] = 2 + remainingStringLen;
            }
        }
        /* if last character of string is different to the first character
              return maximum of -
        // 1. Remove last character & recur for the remaining substring X[left, right-1]
        // 2. Remove first character & recur for the remaining substring X[left+1, right] */
        dp[left][right] = Math.max(longestPalindromic_Substring_Memoization(str, left+1, right, dp),
                longestPalindromic_Substring_Memoization(str, left, right-1, dp));

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
        int max = 1;
        int pMax =0;
        //fill the matrix from right bottom corner
        for(int i =s.length()-1; i>=0; i--){
            dp[i][i] = 1;
            for(int j= i+1; j<s.length();j++){
                //cases 1: if same char bottom left + 2
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] =  dp[i+1][j-1] + 2;
                }
                max = Math.max(max, dp[i][j]);
                if(max>pMax){
                    pMax=max;
                    System.out.println(s.substring(i,j+1));
                }
            }
        }
        //return right top corner as we are fill the matrix from bottom up
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromic_Substring_topDown("aabba"));
        System.out.println(longestPalindromic_Substring_Memoization("asdaad"));
        System.out.println(longestPalindromicSubsequence("asdaad"));
    }

}