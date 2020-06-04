/**
 * [ DP_07_02 ] [ Longest Palindromic Subsequence ]
 * _________________________________________________________________________________________________________
 What is the longest palindromic subsequence?
 The longest palindromic subsequence is the longest sequence of characters in a string that spells
 the same forwards and backward. A subsequence differs from a substring since characters in a subsequence
 are not required to be at consecutive positions in the original string.

 Example
 Take string "ABBCDABBC", for example. Then the longest palindromic subsequence in this string is "BBABB".

 This problem is almost same as previous problem here we are compering chatAt i, j withIn string +
 also if char matches we are incrementing the count by 2

 DP logic: dp[i][j]: the longest palindromic subsequence's length of substring(i, j),
 here i, j represent left, right indexes in the string
 State transition:
 dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
 otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
 Initialization: dp[i][i] = 1
 */
package DynamicProgramming;
public class _07_02_LC_Longest_Palindromic_Subsequence_DP {

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
        System.out.println(longestPalindromicSubsequence("ABBCDABBC"));

    }




}
