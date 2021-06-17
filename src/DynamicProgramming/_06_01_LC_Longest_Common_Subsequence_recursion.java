/**
* [ _06_01 ] [ Longest Common Subsequence  ]
______________________________________________________________________________________________________________
 Given two strings text1 and text2, return the length of their longest common subsequence.

 A subsequence of a string is a new string generated from the original string with some characters(can be none)
 deleted without changing the relative order of the remaining characters.
 (eg, "ace" is a subsequence of "abcde" while "aec" is not).

 s1= adabd
 s2= abd
 o/p = 3 (abd) not the adb

 // Method1()- recursive solution(Top- down approach)
 // time complexity - O(2^(m+n))
 // space complexity - O(m+n)

 */
package DynamicProgramming;
public class _06_01_LC_Longest_Common_Subsequence_recursion {
    //Method 1:
    // recursive solution(Top- down approach) time complexity - O(2^(m+n)) space complexity - O(m+n)
    static int LCS_topDown(String s1, String s2){
        //bases test check
        if(s1==null || s2==null || s1.length()==0 || s2.length() ==0) return 0;
        return LCS_topDown(s1, s2, 0, 0);
    }

    static int LCS_topDown(String s1, String s2, int i, int j){
        //base cases : if we reach the end of either of strings
        if(i==s1.length() || j == s2.length())
            return 0;

        //condition one : if both matching char
        if(s1.charAt(i)== s2.charAt(j)){
            return 1+ LCS_topDown(s1, s2, i+1, j+1);
        }
        //else recursive call with and without current char
        else{
            return Math.max(LCS_topDown(s1, s2, i+1, j), //without
                    LCS_topDown(s1, s2, i, j+1));        //with
        }
    }

    //Method 2:
    // recursive solution(Top- down approach with memoization)
    //time complexity - O(m*n) space complexity - O(m*n)
    static int LCS_topDown_memoization(String s1, String s2){
        //bases test check
        if(s1==null || s2==null || s1.length()==0 || s2.length() ==0) return 0;
        int[][] dp = new int[s1.length()][s2.length()];
        for(int i =0; i<dp.length; i++){
            for(int j =0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return LCS_topDown_memoization(s1, s2, 0, 0, dp);
    }

    static int LCS_topDown_memoization(String s1, String s2, int i, int j, int[][] dp){
        //base cases : if we reach the end of either of strings
        if(i==s1.length() || j == s2.length()) return 0;
        // if already computed
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        //condition one : if both matching char
        if(s1.charAt(i)== s2.charAt(j)){
            return 1+ LCS_topDown_memoization(s1, s2, i+1, j+1, dp);
        }
        //else recursive call with and without current char
        else{
            return dp[i][j] = Math.max(LCS_topDown_memoization(s1, s2, i+1, j, dp), //without
                    LCS_topDown_memoization(s1, s2, i, j+1, dp));        //with
        }
    }


    public static void main(String[] args) {
        System.out.println(LCS_topDown("adabd", "adb"));
        System.out.println(LCS_topDown_memoization("adabd", "adb"));
    }
}
