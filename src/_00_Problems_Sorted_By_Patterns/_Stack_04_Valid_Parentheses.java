/* [ _Stack_04_ ] [ Valid_Parentheses ]
_______________________________________________________________________________
Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.Stack;

public class _Stack_04_Valid_Parentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
        System.out.println(isValid("()[]{{"));
    }

}
