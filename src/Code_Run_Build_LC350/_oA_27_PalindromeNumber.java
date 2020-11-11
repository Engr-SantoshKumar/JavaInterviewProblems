/*
 * [ _oA_27_ ] [Palindrome Number  ]
______________________________________________________________________________________________________________
Determine whether an integer is a palindrome. An integer is a palindrome when it
reads the same backward as forward.
Example 1:

Input: x = 121
Output: true
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-.

 */
package Code_Run_Build_LC350;
public class _oA_27_PalindromeNumber {

    public static boolean isPalindrome(int x) {
        //base cases
        if(x<0 ||(x!=0 && x%10==0)) return false;
        int y = x;
        int res = 0;
        while(y != 0) {
            res = res * 10 + y % 10;
            y /= 10;
        }
        return x == res;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-212));
        System.out.println(isPalindrome(12));
    }
}
