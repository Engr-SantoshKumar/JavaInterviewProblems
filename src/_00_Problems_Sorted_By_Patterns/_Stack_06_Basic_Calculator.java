/* [ _Stack_06_ ] [ Basic_Calculator ]
_______________________________________________________________________________
Given a string s which represents an expression, evaluate this expression and return its value.

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will
be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical
expressions, such as eval().

Input: s = "3+2*2"
Output: 7
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.Stack;

public class _Stack_06_Basic_Calculator {

    public static int calculate(String s) {
        
        if(s==null || s.length()==0)
        return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        int len = s.length();
        for(int i=0; i<len; i++){
            if(Character.isDigit(s.charAt(i))){
                num = s.charAt(i)-'0';
            }
            if(!Character.isDigit(s.charAt(i)) || i==len-1){
                if(sign=='-'){ //if at i its (-) push -number
                    stack.push(-num);
                }
                if(sign=='+'){ //if at i its (+) push number
                    stack.push(num);
                }
                if(sign=='*'){ //if its * or / --> pop the current number do operation and push back
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                //num = 0; // reset the tempNumber to 0
            }
        }

        int result = 0;
        for(int i:stack){ // remove each add (as we just left with operations + and - (* and / we did during pushing to stack
            result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate("8+2*2/2-3"));
    }
}
