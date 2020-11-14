/* [ _oA_41_ ] [ Generate Parentheses DFS ]
_______________________________________________________________________________
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
*/
package Code_Run_Build_LC350;
import java.util.ArrayList;
import java.util.List;

public class _oA_41_Generate_Parentheses_DFS {

    public static List<String> generateParenthesis(int pair) {
        List<String> result = new ArrayList<String>();
        parentheses("", 0, 0, pair, result);
        return result;
    }

    public static void parentheses(String str, int open, int close, int pair,
                                   List<String> result){
        if(str.length()==pair*2){ // if pair is 3 that means char count is 6 (3*2)
            result.add(str);
            return;
        }
        // call for open if its less than pair
        if(open < pair){
            parentheses(str+'{', open+1, close, pair, result);
        }
        // Now call with close briskets ..logic the we will ignore if close > open
        // because those are invalid cases
        if(close < open){
            parentheses(str+'}', open, close+1, pair, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
