/* [ _DP_01_ ] [ Longest Common Substring Brute Force (Expand Around Center) ]
_______________________________________________________________________________
We observe that a palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center,
and there are only 2n−1 such centers.
You might be asking why there are 2n −1 but not nn centers?
The reason is the center of a palindrome can be in between two letters.
Such palindromes have even number of letters (such as "abba") and its center are between the two 'b's.
*/
package _00_Problems_Sorted_By_Patterns;
public class _DP_02_01_Longest_Palindromic_Substring_BruteForce_DP {
    private static int lo, maxLen;
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i + 1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private static void extendPalindrome(String s, int start, int end ) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if (maxLen < end - start - 1) {
            lo = start + 1; //--> setting the starting point of string
            maxLen = end - start - 1;
        }
    }

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
                if(str.charAt(i) == str.charAt(j)){
                    // either size >3 or if <3, substring (i+1, j-1) should be a palindrome
                    dp[i][j] = ((j-i < 3) || dp[i+1][j-1]);
                }
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
        System.out.println(longestPalindrome(str));
        System.out.println(longestPalindromicSubstring(str));
    }
}
