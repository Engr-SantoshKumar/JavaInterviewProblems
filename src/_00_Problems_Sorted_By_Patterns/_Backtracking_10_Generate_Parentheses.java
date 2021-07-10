/* [ _Backtracking_10_ ] [ Generate Parentheses DFS ]
_______________________________________________________________________________
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.LinkedList;
import java.util.List;

public class _Backtracking_10_Generate_Parentheses {
    public static List<String> generateParentheses(int pair){
        List<String> result = new LinkedList<>();
        Parentheses("", 0, 0, pair, result);
        return result;
    }

    public static void Parentheses(String str, int open, int close, int pair, List<String> result){
        //base case
        if(str.length() == pair*2){
            result.add(str);
            return;
        }

        //construct open if required
        if(open < pair){
            Parentheses(str+'(', open+1, close, pair, result);
        }
        // Now call with close briskets ..logic the we will ignore if close > open
        // because those are invalid cases
        if(close < open){
            Parentheses(str+')', open, close+1, pair, result);
        }
    }
    public static void main(String[] args) {
        System.out.println(generateParentheses(3));
    }
}
