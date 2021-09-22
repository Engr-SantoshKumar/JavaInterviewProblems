/**
 * [Goo2-04 ] [_Goo2_04_Generate_Parentheses ]
 * -----------------------------------------------------------------------------------------------------
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 For example, given n = 3, a solution set is:

 Logic:
 The idea here is to only add '(' and ')' that we know will guarantee us a solution (instead of adding 1 too many close).
 Once we add a '(' we will then discard it and try a ')' which can only close a valid '('.
 Each of these steps are recursively called.

 */

package PrepSetTwo;

import java.util.ArrayList;
import java.util.List;

public class _Goo2_04_02_Generate_Parentheses_DFS {


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
