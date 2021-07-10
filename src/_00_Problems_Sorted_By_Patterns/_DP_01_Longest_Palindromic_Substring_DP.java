/* [ _DP_01_ ] [ Longest Palindromic Substring DP ]
_______________________________________________________________________________
To improve over the brute force solution, we first observe how we can avoid unnecessary re-computation
while validating palindromes. Consider the case "ababa". If we already knew that "bab" is a palindrome,
it is obvious that "ababa" must be a palindrome since the two left and right end letters are the same.

Points to considered:

One Char string   i.e.  j-i == 0, only a character is a palindrome, e.g : A
Two Char string   i.e.  j-i == 1 && s.charAt(i) == s.charAt(j), ij is a palindrome, e.g: AA
Three Char string i.e.  j-i == 2 && s.charAt(i) == s.charAt(j), no matter what between i and j, e.g: A#A
So basically if  str >=3 (A, AA, ABA we just need to chek if s.charAt(i) == s.charAt(j) if TRUE its palindrome
More Than Three chars: s.charAt(i) == s.charAt(j) && substring (i+1, j-1)
                            ↑               ↑
        e.g: ABABA -->      A               A      +   substring (i+1, j-1) -->  BAB

Complexity Analysis
Time complexity : O(n^2)O(n^2)
Space complexity : O(n^2)O(n^2).
*/
package _00_Problems_Sorted_By_Patterns;
public class _DP_01_Longest_Palindromic_Substring_DP {

    public static String longestPalindromicSubstring(String str){
        int len = str.length();
        String result = null;
        int palindromeStartsAt = 0;
        int maxLen = 0;

        //// dp[i][j] indicates whether substring s starting at index i and ending at j is palindrome
        boolean[][] dp = new boolean[len][len];

        // we will fill the matrix from bottom right to left top
        for(int i=len-1; i>=0; i--){    // keep increasing the possible palindrome string
            for(int j=i; j<len; j++){   // find the max palindrome within this window of (i,j)

                //check if substring between (i,j) is palindrome
                dp[i][j] = (str.charAt(i) == str.charAt(j)) // this is common check for str size 1,2,3, or < 3
                            &&
                           ((j-i < 3) || dp[i+1][j-1]); // above cond + any of this should be true..
                                                        // either size >3 or if <3, substring (i+1, j-1) should be a palindrome

                //update max palindrome string
                if(dp[i][j] && (j-i+1 > maxLen)) {
                    palindromeStartsAt = i;
                    maxLen = j-i+1;
                }
            }
        }
        return str.substring(palindromeStartsAt, palindromeStartsAt+maxLen);
    }
    public static void main(String[] args) {
        String str = "AAAABBAA";
        System.out.println(longestPalindromicSubstring(str));
    }
}
