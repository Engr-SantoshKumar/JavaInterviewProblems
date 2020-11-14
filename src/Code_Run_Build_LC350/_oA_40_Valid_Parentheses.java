/* [ _oA_40_ ] [ Valid Parentheses ]
_______________________________________________________________________________
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
*/
package Code_Run_Build_LC350;

import java.util.Stack;

public class _oA_40_Valid_Parentheses {
    public static boolean isValid(String s) {
        if(s.length()%2==1) return false;
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if(c=='(') stack.push(')');
            else if(c=='{') stack.push('}');
            else if(c=='[') stack.push(']');
            else{
                if(stack.empty()|| stack.pop()!=c)return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isValid("({})"));
        System.out.println(isValid("({)}"));
    }
}
