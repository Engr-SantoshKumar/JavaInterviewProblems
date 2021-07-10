/* [ _Backtracking_10_ ] [ Generate Parentheses DFS ]
_______________________________________________________________________________
Given n pairs of parentheses, write a function to generate all combinations of
 well-formed parentheses.

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class _Backtracking_10_Generate_Parentheses_DFS {

    public static List<String> generateParenthesisBFS(int count){
        List<String> result = new ArrayList<>();
        //base cases
        if(count<1) return result;
        Queue<Parenthesis> queue = new ArrayDeque<>();
        // add a empty string to start with
        queue.offer(new Parenthesis("", 0, 0));

        //BFS
        while(!queue.isEmpty()){
            Parenthesis current = queue.poll();
            if(current.str.length() == count*2){
                result.add(current.str);
            }
            if(current.open < count){
                queue.offer(new Parenthesis(current.str+'(', current.open+1, current.close ));
            }
            if(current.close < current.open){
                queue.offer(new Parenthesis(current.str+')', current.open, current.close+1 ));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesisBFS(3));
    }
}
    class Parenthesis {
        String str;
        int open;
        int close;

        public Parenthesis(String str, int open, int close) {
            this.str = str;
            this.open = open;
            this.close = close;
        }
}
