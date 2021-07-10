/* [ _DP_01_ ] [ Longest Common Substring Brute Force (Expand Around Center) ]
_______________________________________________________________________________
We observe that a palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center,
and there are only 2n−1 such centers.
You might be asking why there are 2n −1 but not nn centers?
The reason is the center of a palindrome can be in between two letters.
Such palindromes have even number of letters (such as "abba") and its center are between the two 'b's.
*/
package _00_Problems_Sorted_By_Patterns;
public class _DP_01_Longest_Palindromic_Substring_Brute_Force {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddLen = expandBothSideOfCenter(s, i, i);
            int evenLen = expandBothSideOfCenter(s, i, i + 1);
            int len = Math.max(oddLen, evenLen);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandBothSideOfCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        String str = "AAAABBAA";
        System.out.println(longestPalindrome(str));
    }
}
